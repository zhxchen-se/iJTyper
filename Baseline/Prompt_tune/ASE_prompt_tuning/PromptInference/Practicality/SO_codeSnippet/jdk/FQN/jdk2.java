public class jdk2 {
    public static void main(java.lang.String[] args) {
        java.lang.String userDirPropertyName = "user.dir";
        java.io.File initialUserDir = new java.io.File(java.lang.System.getProperty(userDirPropertyName));
        java.lang.System.out.println(("files in " + initialUserDir.getAbsolutePath()) + ":");
    }
}

