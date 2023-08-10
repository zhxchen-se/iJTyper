public class Android38 {
    static java.lang.String serviceDomain = "http://staging.abaqus.net";

    static java.lang.String postUrl = android.Android38.serviceDomain + "/geo/upl/wupload/pictures";

    static java.lang.String CRLF = "\r\n";

    static java.lang.String twoHyphens = "--";

    static java.lang.String boundary = "*****mgd*****";

    private java.lang.String name = null;

    private java.lang.String password = null;

    private java.io.DataOutputStream dataStream = null;

    enum ReturnCode {

        noPicture,
        unknown,
        http201,
        http400,
        http401,
        http403,
        http404,
        http500;}

    public Android38(java.lang.String name, java.lang.String password) {
        this.name = name;
        this.password = password;
    }

    public static void setServiceDomain(java.lang.String domainName) {
        android.Android38.serviceDomain = domainName;
    }

    public static java.lang.String getServiceDomain() {
        return android.Android38.serviceDomain;
    }

    public android.Android38.ReturnCode uploadPicture(java.lang.String pictureFileName) {
        java.io.File uploadFile = new java.io.File(pictureFileName);
        if (uploadFile.exists()) {
            try {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(uploadFile);
                java.net.URL connectURL = new java.net.URL(android.Android38.postUrl);
                java.net.HttpURLConnection conn = ((java.net.HttpURLConnection) (connectURL.openConnection()));
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setUseCaches(false);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("User-Agent", "myGeodiary-V1");
                conn.setRequestProperty("Connection", "Keep-Alive");
                conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + android.Android38.boundary);
                conn.connect();
                dataStream = new java.io.DataOutputStream(conn.getOutputStream());
                writeFormField("login", name);
                writeFormField("password", password);
                writeFileField("photo1", pictureFileName, "image/jpg", fileInputStream);
                dataStream.writeBytes(((android.Android38.twoHyphens + android.Android38.boundary) + android.Android38.twoHyphens) + android.Android38.CRLF);
                fileInputStream.close();
                dataStream.flush();
                dataStream.close();
                dataStream = null;
                java.lang.String response = getResponse(conn);
                conn.getResponseCode();
                if (response.contains("uploaded successfully")) {
                    return android.Android38.ReturnCode.http201;
                } else {
                    return android.Android38.ReturnCode.http401;
                }
            } catch (java.net.MalformedURLException mue) {
                java.lang.System.out.println("GeoPictureUploader.uploadPicture: Malformed URL: " + mue.getMessage());
                return android.Android38.ReturnCode.http400;
            } catch (java.io.IOException ioe) {
                java.lang.System.out.println("GeoPictureUploader.uploadPicture: IOE: " + ioe.getMessage());
                return android.Android38.ReturnCode.http500;
            } catch (java.lang.Exception e) {
                java.lang.System.out.println("GeoPictureUploader.uploadPicture: unknown: " + e.getMessage());
                return android.Android38.ReturnCode.unknown;
            }
        } else {
            return android.Android38.ReturnCode.noPicture;
        }
    }

    private java.lang.String getResponse(java.net.HttpURLConnection conn) {
        try {
            java.io.DataInputStream dis = new java.io.DataInputStream(conn.getInputStream());
            byte[] data = new byte[1024];
            int len = dis.read(data, 0, 1024);
            dis.close();
            conn.getResponseCode();
            if (len > 0) {
                return new java.lang.String(data, 0, len);
            } else {
                return "";
            }
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("GeoPictureUploader: biffed it getting HTTPResponse");
            return "";
        }
    }

    private java.lang.String getResponseOrig(java.net.HttpURLConnection conn) {
        java.io.InputStream is = null;
        try {
            is = conn.getInputStream();
            int ch;
            java.lang.StringBuffer sb = new java.lang.StringBuffer();
            while ((ch = is.read()) != (-1)) {
                sb.append(((char) (ch)));
            } 
            return sb.toString();
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("GeoPictureUploader: biffed it getting HTTPResponse");
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (java.lang.Exception e) {
            }
        }
        return "";
    }

    private void writeFormField(java.lang.String fieldName, java.lang.String fieldValue) {
        try {
            dataStream.writeBytes((android.Android38.twoHyphens + android.Android38.boundary) + android.Android38.CRLF);
            dataStream.writeBytes((("Content-Disposition: form-data; name=\"" + fieldName) + "\"") + android.Android38.CRLF);
            dataStream.writeBytes(android.Android38.CRLF);
            dataStream.writeBytes(fieldValue);
            dataStream.writeBytes(android.Android38.CRLF);
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("GeoPictureUploader.writeFormField: got: " + e.getMessage());
        }
    }

    private void writeFileField(java.lang.String fieldName, java.lang.String fieldValue, java.lang.String type, java.io.FileInputStream fis) {
        try {
            dataStream.writeBytes((android.Android38.twoHyphens + android.Android38.boundary) + android.Android38.CRLF);
            dataStream.writeBytes((((("Content-Disposition: form-data; name=\"" + fieldName) + "\";filename=\"") + fieldValue) + "\"") + android.Android38.CRLF);
            dataStream.writeBytes(("Content-Type: " + type) + android.Android38.CRLF);
            dataStream.writeBytes(android.Android38.CRLF);
            int bytesAvailable = fis.available();
            int maxBufferSize = 1024;
            int bufferSize = java.lang.Math.min(bytesAvailable, maxBufferSize);
            byte[] buffer = new byte[bufferSize];
            int bytesRead = fis.read(buffer, 0, bufferSize);
            while (bytesRead > 0) {
                dataStream.write(buffer, 0, bufferSize);
                bytesAvailable = fis.available();
                bufferSize = java.lang.Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fis.read(buffer, 0, bufferSize);
            } 
            dataStream.writeBytes(android.Android38.CRLF);
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("GeoPictureUploader.writeFormField: got: " + e.getMessage());
        }
    }

    public static void main(java.lang.String[] args) {
        if (args.length >= 0) {
            android.Android38 gpu = new android.Android38("john", "notmyrealpassword");
            java.lang.String picName = args[0];
            gpu.uploadPicture(picName);
            java.lang.System.out.printf("done");
        }
    }
}

