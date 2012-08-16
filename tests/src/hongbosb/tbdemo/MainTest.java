package hongbosb.tbdemo;

import android.test.AndroidTestCase;

import java.util.*;

import hongbosb.tbdemo.utils.*;
import hongbosb.tbdemo.*;
/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class hongbosb.tbdemo.MainActivityTest \
 * hongbosb.tbdemo.tests/android.test.InstrumentationTestRunner
 */
public class MainTest extends AndroidTestCase {

    public void testRssBean() throws Exception {
        RssBean b1 = new RssBean();
        b1.guid = "1";

        RssBean b2 = new RssBean();
        b2.guid = "1";

        Set set = new HashSet();
        set.add(b1);
        set.add(b2);
        assertTrue(b1.equals(b2));
        assertEquals(b1, b2);
    }

    public void testDiff() throws Exception {
        List<RssBean> l1 = new ArrayList<RssBean>();
        List<RssBean> l2 = new ArrayList<RssBean>();
        RssBean b1 = new RssBean();
        b1.guid = "1";
        RssBean b2 = new RssBean();
        b2.guid = "2";
        RssBean b3 = new RssBean();
        b3.guid = "3";
        RssBean b4 = new RssBean();
        b4.guid = "4";
        l1.add(b1);
        l1.add(b2);
        l2.add(b3);
        l2.add(b2);

        List<RssBean> r = ListUtils.diff(l1, l2);
        assertEquals("3", r.get(0).guid);
        assertEquals(1, r.size());
    }
}
