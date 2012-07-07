package hongbosb.tbdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MainActivity extends Activity {
    static public final String TAG = "MainActivity";

    private String[] mImageUrls;
    private ImageLoader mImageLoader;
    private FlowAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        loadJsonData();
        ListView listView = getListView();
        mAdapter = new FlowAdapter();
        listView.setAdapter(mAdapter);

        mImageLoader = new ImageLoader(this);
    }

    public ListView getListView() {
        return (ListView)findViewById(R.id.list);            
    }

    private void loadJsonData() {
        String content = loadContent();
        JsonParser parser = new  JsonParser(content);
        mImageUrls = parser.getImageUrls();
    }

    private String loadContent() {
        try {
            URL url = new URL("http://192.168.1.104:8888");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String result = "";
            String line = reader.readLine();
            while (line != null) {
                result += line + "\n";
                line = reader.readLine();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private class FlowAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            if (mImageUrls == null) {
                return 0;
            } else {
                return mImageUrls.length;
            }
        }

        @Override
        public Object getItem(int pos) {
            return pos;
        }

        @Override
        public long getItemId(int pos) {
            return pos;
        }

        public View getView(int pos, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.flow_item, null);
            }


            ImageView image = (ImageView)view.findViewById(R.id.image);
            String url = mImageUrls[pos];
            mImageLoader.loadImage(image, url);
            return view;
        }
    }
}
