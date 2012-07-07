package hongbosb.tbdemo;

import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.app.Activity;
import android.util.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ConcurrentHashMap;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.lang.ref.SoftReference;

public class ImageLoader {
    static public final String TAG = "ImageLoader";

    ExecutorService mServices;
    MemoryCache mCache;
    Activity mActivity;

    ConcurrentHashMap<ImageView, String> mPendingMap = new ConcurrentHashMap<ImageView, String>();

    public ImageLoader(Activity activity) {
        mServices = Executors.newFixedThreadPool(5);
        mActivity = activity;
        mCache = new MemoryCache();
    }

    public void loadImage(ImageView image, String url) {
        mPendingMap.put(image, url);

        //First check if the bitmap is in cache already.
        Bitmap cachedBitmap = mCache.get(url);
        if (cachedBitmap != null) {
            image.setImageBitmap(cachedBitmap);
        } else {
            //image.setImageResource(R.drawable.shit_icon);
            mServices.execute(new LoadHandler(image, url));
        }
    }

    class LoadHandler implements Runnable {
        String mUrl; 
        ImageView mImage;
        public LoadHandler(ImageView image, String url) {
            mUrl = url;
            mImage = image;
        }

        @Override
        public void run() {
            final Bitmap bitmap = getBitmapFromWeb(mUrl);
            mCache.put(mUrl, bitmap);
            if (bitmap != null) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mImage.setImageBitmap(bitmap);
                    }
                });
            }
        }

        private Bitmap getBitmapFromWeb(String url) {
            File file = null;
            HttpURLConnection conn = null;
            try {
                URL conUrl = new URL(url);
                conn = (HttpURLConnection)conUrl.openConnection();
                InputStream in = new BufferedInputStream(conn.getInputStream());

                FileCache fileCache = new FileCache();
                file = fileCache.getFile(url);
                FileOutputStream out = new FileOutputStream(file);

                Utils.copyStream(in, out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn.disconnect();
            }

            if (file != null) {
                return BitmapFactory.decodeFile(file.getPath());
            } else {
                return null;
            }
        }
    }

    class MemoryCache {
        ConcurrentHashMap<String, SoftReference<Bitmap>> mCache = new ConcurrentHashMap<String, SoftReference<Bitmap>>();

        private void put(String url, Bitmap bitmap) {
            SoftReference ref = new SoftReference(bitmap);
            mCache.put(url, ref);
        }

        private Bitmap get(String url) {
            SoftReference<Bitmap> ref = mCache.get(url);
            if (ref == null) {
                return null;
            } else {
                return ref.get();
            }
        }
    }
}
