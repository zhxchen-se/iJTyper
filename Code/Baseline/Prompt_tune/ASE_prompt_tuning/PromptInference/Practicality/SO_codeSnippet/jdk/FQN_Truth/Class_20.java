class Class_20 {
    public static void receive() {
        try {
            java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.BufferedInputStream(null));
            java.io.DataOutputStream dos = new java.io.DataOutputStream(new java.io.BufferedOutputStream(null, 0));
            int number = dis.readInt();
            java.util.ArrayList<java.io.File> files = new java.util.ArrayList<java.io.File>(number);
            java.lang.System.out.println("Number of Files to be received: " + number);
            for (int i = 0; i < number; i++) {
                java.io.File file = new java.io.File(dis.readUTF());
                files.add(file);
            }
            int n = 0;
            byte[] buf = new byte[4092];
            for (int i = 0; i < files.size(); i++) {
                java.lang.System.out.println("Receiving file: " + files.get(i).getName());
                java.io.FileOutputStream fos = new java.io.FileOutputStream("C:\\users\\tom5\\desktop\\salestools\\" + files.get(i).getName());
                while ((n = dis.read(buf)) != (-1)) {
                    fos.write(buf, 0, n);
                    fos.flush();
                } 
                fos.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void send(java.util.ArrayList<java.io.File> files) {
        try {
            java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.BufferedInputStream(null));
            java.io.DataOutputStream dos = new java.io.DataOutputStream(new java.io.BufferedOutputStream(null));
            java.lang.System.out.println(files.size());
            dos.writeInt(files.size());
            dos.flush();
            // write file names
            for (int i = 0; i < files.size(); i++) {
                dos.writeUTF(files.get(i).getName());
                dos.flush();
            }
            int n = 0;
            byte[] buf = new byte[4092];
            for (int i = 0; i < files.size(); i++) {
                java.lang.System.out.println(files.get(i).getName());
                java.io.FileInputStream fis = new java.io.FileInputStream(files.get(i));
                while ((n = fis.read(buf)) != (-1)) {
                    dos.write(buf, 0, n);
                    dos.flush();
                }
            }
            dos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

