package hongbosb.tbdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class LazyAdapter extends BaseAdapter {

    Activity mActivity;
    String[] mStrs;
    ImageLoader mLoader;
    
    public LazyAdapter(Activity a, String[] strs) {
        mActivity = a;
        mStrs = strs;
        mLoader = new ImageLoader(mActivity);
    }

    @Override
    public int getCount() {
        return mStrs.length;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public Object getItem(int pos) {
        return pos;
    }

//    @Override
//    public View getView(int pos, View convertView, ViewGroup parent) {
//        View view = convertView;
//        if (view == null) {
//            view = LayoutInflater.from(mActivity).inflate(R.layout.item, null);
//        }
//
//        TextView content = (TextView)view.findViewById(R.id.content);
//        content.setText("item " + pos);
//
//        ImageView image = (ImageView)view.findViewById(R.id.image);
//        String url = mStrs[pos];
//        mLoader.loadImage(image, url);
//        return view;
//    }
    public View getView(int pos, View convertView, ViewGroup parent) {
        return null;
    }
}
