package in.rahul.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtil {

    public static String getResourcePath(String resource){
       return Paths.get("src","test","resources").resolve(resource).toFile().getAbsolutePath();
    }
}
