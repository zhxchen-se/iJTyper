public class Class_11 {
  public static void main(java.lang.String[] args) {
    try {
      // Create new file
      java.lang.String content = "This is the content to write into create file";
      java.lang.String path = "D:\\a\\hi.txt";
      java.io.File file = new java.io.File(path);
      // If file doesn't exists, then create it
      if (!java.io.File.exists()) {
        java.io.File.createNewFile()
      }
      java.io.FileWriter fw = new java.io.FileWriter(java.io.File.getAbsoluteFile());
      java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
      java.io.Writer.write(java.lang.String)
      java.io.BufferedWriter.close()
    } catch (java.lang.Exception e) {
      java.io.PrintStream.println(java.lang.Object)
    }
    javax.swing.JFileChooser c = new javax.swing.JFileChooser();
    javax.swing.JFileChooser.showOpenDialog(java.awt.Component)
    java.io.File writeFile = javax.swing.JFileChooser.getSelectedFile();
    java.lang.String content = "Input the data here to be written to your file";
    try {
      java.io.FileWriter fw = new java.io.FileWriter(writeFile);
      java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
      java.io.Writer.append(java.lang.CharSequence)
      java.io.Writer.append(java.lang.CharSequence)
      java.io.BufferedWriter.close()
      java.io.OutputStreamWriter.close()
    } catch (java.lang.Exception exc) {
      java.io.PrintStream.println(java.lang.Object)
    }
  }
}
