public class gwt_class_39 {
    public class ReportsServiceImpl extends com.google.gwt.user.server.rpc.RemoteServiceServlet {
        public java.lang.String myMethod(java.lang.String s) {
            java.io.File f = new java.io.File("/excelTestFile.xls");
            java.lang.String filename = f.getName();
            int length = 0;
            try {
                javax.servlet.http.HttpServletResponse resp = getThreadLocalResponse();
                javax.servlet.ServletOutputStream op = resp.getOutputStream();
                javax.servlet.ServletContext context = getServletConfig().getServletContext();
                resp.setContentType("application/octet-stream");
                resp.setContentLength(((int) (f.length())));
                resp.setHeader("Content-Disposition", ("attachment; filename*=\"utf-8\'\'" + filename) + "");
                byte[] bbuf = new byte[1024];
                java.io.DataInputStream in = new java.io.DataInputStream(new java.io.FileInputStream(f));
                while ((in != null) && ((length = in.read(bbuf)) != (-1))) {
                    op.write(bbuf, 0, length);
                } 
                in.close();
                op.flush();
                op.close();
            } catch (java.lang.Exception ex) {
                ex.printStackTrace();
            }
            return "Server says: " + filename;
        }
    }
}

