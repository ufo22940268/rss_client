package hongbosb.tbdemo;

import android.os.*;

public class RssBean implements Parcelable {

    public String guid;
    public String title;
    public long date;
    public String link;

    public RssBean() {
    }

    @Override
    public String toString() {
        return "\nguid:" + guid + "\t" 
            + "title:" + title + "\t"
            + "date:" + date + "\t"
            + "link:" + link + "\t";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flag) {
        out.writeString(title);
    }

    public RssBean(Parcel in) {
        title = in.readString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RssBean) {
            RssBean ro = (RssBean)o;
            return ro.guid == guid;
        } else {
            return false;
        }
    }

    public static final Parcelable.Creator<RssBean> CREATOR
        = new Parcelable.Creator<RssBean>() {
            public RssBean createFromParcel(Parcel in) {
                return new RssBean(in);
            }

            public RssBean[] newArray(int size) {
                return new RssBean[size];
            }
        };

}
