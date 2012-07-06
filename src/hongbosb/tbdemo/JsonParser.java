package hongbosb.tbdemo;

import org.json.*;
import java.util.List;
import java.util.ArrayList;

public class JsonParser {
    private JSONTokener mTokener ;

    public JsonParser(String content) {
        mTokener = new JSONTokener(content);
    }

    public String[] getImageUrls() {
        List<String> list = null;
        try {
            JSONObject jo = new JSONObject(mTokener);
            JSONArray jArray = jo.getJSONArray("pics");
            list = new ArrayList<String>();
            for (int i = 0; i < jArray.length(); i ++) {
                list.add(jArray.getString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] strs = new String[list.size()];
        return list.toArray(strs);
    }
}
