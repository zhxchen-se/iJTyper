package java.jdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class jdk10 {
    public void h1() {
        File is = null;
        try {
            FileInputStream input = new FileInputStream(is);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}

