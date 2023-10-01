public class Class_11 {
    public static void main(java.lang.String[] args) {
        try {

            java.lang.String content = "This is the content to write into create file";
            java.lang.String path = "D:\\a\\hi.txt";
            java.io.File file = new java.io.File(path);

            if (!file.exists()) {
                file.createNewFile();
            }
            java.io.FileWriter fw = new java.io.FileWriter(file.getAbsoluteFile());
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);

            bw.write(content);

            bw.close();
        } catch (java.lang.Exception e) {
            java.lang.System.out.println(e);
        }
        javax.swing.JFileChooser c = new javax.swing.JFileChooser();
        c.showOpenDialog(c);
        java.io.File writeFile = c.getSelectedFile();
        java.lang.String content = "Input the data here to be written to your file";
        try {
            java.io.FileWriter fw = new java.io.FileWriter(writeFile);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
            bw.append(content);
            bw.append("hiiiii");
            bw.close();
            fw.close();
        } catch (java.lang.Exception exc) {
            java.lang.System.out.println(exc);
        }
    }
}

