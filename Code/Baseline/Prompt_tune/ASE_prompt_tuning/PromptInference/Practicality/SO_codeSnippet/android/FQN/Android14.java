public class Android14 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        try {
            java.net.URL u = new java.net.URL("http://www.path.to/a.mp4?video");
            java.net.HttpURLConnection c = ((java.net.HttpURLConnection) (u.openConnection()));
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();
            java.lang.String root = "root";
            java.io.FileOutputStream f = new java.io.FileOutputStream(new java.io.File(root, "Video.mp4"));
            java.io.InputStream in = c.getInputStream();
            byte[] buffer = new byte[1024];
            int len1 = 0;
            while ((len1 = in.read(buffer)) > 0) {
                f.write(buffer);
            } 
            f.close();
        } catch (java.net.MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (java.net.ProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (java.io.FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (java.io.IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

