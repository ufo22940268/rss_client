package hongbosb.tbdemo.utils;

import java.util.*;

import hongbosb.tbdemo.*;

public class ListUtils {

    public static List<RssBean> diff(List<RssBean> b1, List<RssBean> b2) {
        List<RssBean> diffs = new ArrayList<RssBean>();
        for (RssBean bean : b2) {
            if (!b1.contains(bean)) {
                diffs.add(bean);
            }
        }
        return diffs;
    }
}

