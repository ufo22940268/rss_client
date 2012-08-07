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
import android.widget.TextView;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.HandlerThread;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;


public class MainActivity extends Activity implements Callback {
    static public final String TAG = "MainActivity";

    static public final int MESSAGE_REFRESH_ADAPTER = 0;

    static public final String BUNDLE_BEAN_LIST = 0;

    private String[] mImageUrls;
    private FlowAdapter mAdapter;

    private long mDate = 8;
    private Handler mMainHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mMainHandler = new Handler(this);

        ListView listView = getListView();
        mAdapter = new FlowAdapter();
        listView.setAdapter(mAdapter);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MESSAGE_REFRESH_ADAPTER:
                List<RssBean> beans 
                    = msg.getData().getParcelableArrayList(BUNDLE_BEAN_LIST);
                if (beans == null) {
                    return;
                }

                FlowAdapter adapter = getAdapter();
                if (adapter.getCount() == 0) {
                    adapter.setBeans(beans);
                    adapter.notifyDataSetChanged();
                }
        }
        return true;
    }

    private ListView getListView() {
        return ((PullToRefreshListView)findViewById(R.id.list)).getRefreshableView();            
    }

    private FlowAdapter getAdapter() {
        return mAdapter;
    }

    private long getDateParam() {
       if (mDate >= 0) {
           return mDate --;
       }
       return -1;
    }

    private String getUrl() {
        return "http://192.168.121.10:8888/query?date=" + String.valueOf(getDateParam());
    }

    private class FlowAdapter extends BaseAdapter {

        private List<RssBean> mBeans;

        private void setBeans(List<RssBean> beans) {
            mBeans = beans;
        }

        @Override
        public int getCount() {
            if (mBeans == null) {
                return 0;
            } else {
                return mBeans.size();
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
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_list_item, null);
            }

            String title = mBeans.get(pos).title;
            ((TextView)view.findViewById(R.id.title)).setText(title);
            return view;
        }
    }

    private class LoaderHandler extends HandlerThread implements Callback {

        private Handler mHandler;

        public LoaderHandler() {
            super("hongbosbloader");
        }

        private void requestLoading() {
            if (mHandler == null) {
                mHandler = new Handler(getLooper(), this);
            }

            mHandler.sendEmptyMessage(0);
        }

        @Override
        public boolean handleMessage(Message msg) {
            ArrayList<RssBean> beans = loadXmlData();

            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(beans);
            Message msg = new Message();
            msg.setData(bundle);
            msg.what = MESSAGE_REFRESH_ADAPTER;
            mMainHandler.setMessage(msg);

            return true;
        }

        private List<RssBean> loadXmlData() {
            String content = loadContent();
            XmlParser parser = new XmlParser(content);
            List<RssBean> beans = parser.startParsing();
            return beans;
        }

        private String loadContent() {
            try {
                URL url = new URL(getUrl());
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

    }
}
