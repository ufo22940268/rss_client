package hongbosb.tbdemo;

import android.os.*;

public class RssBean implements Parcelable {


    public String title;

    @Override
    public String toString() {
        return "\n" + title + "\n";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flag) {
        out.writeString(title);
    }

    public RssBean() {
    }

    public RssBean(Parcel in) {
        title = in.readString();
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
