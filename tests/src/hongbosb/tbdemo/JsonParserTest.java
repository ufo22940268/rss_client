package hongbosb.tbdemo;

import android.test.AndroidTestCase;
import java.util.Arrays;

public class JsonParserTest extends AndroidTestCase {
    public void testParseContent() throws Exception {
        String content = "{\"pics\": [\"http://127.0.0.1:8888/static/res/1.png\", \"http://127.0.0.1:8888/static/res/3.png\", \"http://127.0.0.1:8888/static/res/4.png\"]}";

        JsonParser parser = new JsonParser(content);
        String[] imgUrls = parser.getImageUrls();
        String[] expected = new String[] {
            "http://127.0.0.1:8888/static/res/1.png",
                "http://127.0.0.1:8888/static/res/3.png",
                "http://127.0.0.1:8888/static/res/4.png"
        };

        assertTrue(Arrays.deepEquals(expected, imgUrls));
    }
}

