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
import android.os.AsyncTask;

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


public class MainActivity extends Activity {
    static public final String TAG = "MainActivity";

    private String[] mImageUrls;
    private FlowAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView listView = getListView();
        mAdapter = new FlowAdapter();
        listView.setAdapter(mAdapter);

        new LoadTask().execute(null, null, null);
    }

    private ListView getListView() {
        return ((PullToRefreshListView)findViewById(R.id.list)).getRefreshableView();            
    }

    private FlowAdapter getAdapter() {
        return mAdapter;
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

    private class LoadTask extends AsyncTask<Void, Void, List<RssBean>> {

        @Override
        protected List<RssBean> doInBackground(Void... params) {
            return loadXmlData();
        }

        @Override
        protected void onPostExecute(List<RssBean> beans) {
            if (beans == null) {
                return;
            }

            FlowAdapter adapter = getAdapter();
            if (adapter.getCount() == 0) {
                adapter.setBeans(beans);
                adapter.notifyDataSetChanged();
            }
        }

        private List<RssBean> loadXmlData() {
            String content = loadContent();
            XmlParser parser = new XmlParser(content);
            List<RssBean> beans = parser.startParsing();
            return beans;
        }

        private String loadContent() {
            try {
                URL url = new URL("http://192.168.121.10:8888/query?date=123");
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
