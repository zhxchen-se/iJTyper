package java.jdk;


import java.awt.*;
import java.io.File;
import java.io.IOException;

public class jdk14 {
    public static void h1(String aFile) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(aFile));
    }

}
