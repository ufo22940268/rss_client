package hongbosb.tbdemo;

import java.io.File;

public class FileCache {

    public static File getFile(String url) {
        String directory = "/mnt/sdcard/tmp/";
        String fileName = "a" + String.valueOf(url.hashCode());
        return new File(directory + fileName);   
    }
}   
