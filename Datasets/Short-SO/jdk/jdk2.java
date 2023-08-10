package java.jdk;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class jdk2 {
    public static void main(String args[]){
        String userDirPropertyName = "user.dir";
        File initialUserDir = new File(System.getProperty(userDirPropertyName));
        System.out.println("files in " + initialUserDir.getAbsolutePath() + ":");
    }
    }


