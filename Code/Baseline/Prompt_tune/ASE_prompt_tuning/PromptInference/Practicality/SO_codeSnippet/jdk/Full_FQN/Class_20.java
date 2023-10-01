class Class_20 {
  public static void receive() {
    try {
      java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.BufferedInputStream(null));
      java.io.DataOutputStream dos = new java.io.DataOutputStream(new java.io.BufferedOutputStream(null, 0));
      // read the number of files from the client
      int number = java.io.DataInputStream.readInt();
      java.util.ArrayList<java.io.File> files = new java.util.ArrayList<java.io.File>(number);
      java.io.PrintStream.println(java.lang.String)
      // read file names, add files to arraylist
      for (int i = 0; i < number; i++) {
        java.io.File file = new java.io.File(java.io.DataInputStream.readUTF());
        java.util.ArrayList.add(java.lang.Object)
      }
      int n = 0;
      byte[] buf = new byte[4092];
      // outer loop, executes one for each file
      for (int i = 0; i < java.util.ArrayList.size(); i++) {
        java.io.PrintStream.println(java.lang.String)
        // create a new fileoutputstream for each new file
        java.io.FileOutputStream fos = new java.io.FileOutputStream("C:\\users\\tom5\\desktop\\salestools\\" + java.util.ArrayList.get(int)###java.io.File.getName());
        // read file
        while ((n = java.io.DataInputStream.read(byte[])) != (-1)) {
          java.io.FileOutputStream.write(byte[],int,int)
          java.io.OutputStream.flush()
        } 
        java.io.FileOutputStream.close()
      }
    } catch (java.io.IOException e) {
      java.lang.Throwable.printStackTrace()
    }
  }

  public void send(java.util.ArrayList<java.io.File> files) {
    try {
      java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.BufferedInputStream(null));
      java.io.DataOutputStream dos = new java.io.DataOutputStream(new java.io.BufferedOutputStream(null));
      java.io.PrintStream.println(int)
      java.io.DataOutputStream.writeInt(int)
      java.io.DataOutputStream.flush()
      // write file names
      for (int i = 0; i < java.util.ArrayList.size(); i++) {
        java.io.DataOutputStream.writeUTF(java.lang.String)
        java.io.DataOutputStream.flush()
      }
      // buffer for file writing, to declare inside or outside loop?
      int n = 0;
      byte[] buf = new byte[4092];
      // outer loop, executes one for each file
      for (int i = 0; i < java.util.ArrayList.size(); i++) {
        java.io.PrintStream.println(java.lang.String)
        // create new fileinputstream for each file
        java.io.FileInputStream fis = new java.io.FileInputStream(java.util.ArrayList.get(int));
        // write file to dos
        while ((n = java.io.FileInputStream.read(byte[])) != (-1)) {
          java.io.DataOutputStream.write(byte[],int,int)
          java.io.DataOutputStream.flush()
        } 
        // should i close the dataoutputstream here and make a new one each time?
      }
      java.io.FilterOutputStream.close()
    } catch (java.io.IOException e) {
      java.lang.Throwable.printStackTrace()
    }
  }
}
