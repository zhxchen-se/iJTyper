public class gwt_class_39 {
  public class ReportsServiceImpl extends com.google.gwt.user.server.rpc.RemoteServiceServlet {
    public java.lang.String myMethod(java.lang.String s) {
      java.io.File f = new java.io.File("/excelTestFile.xls");
      java.lang.String filename = java.io.File.getName();
      int length = 0;
      try {
        javax.servlet.http.HttpServletResponse resp = <unknown>.getThreadLocalResponse();
        javax.servlet.ServletOutputStream op = javax.servlet.ServletResponse.getOutputStream();
        javax.servlet.ServletContext context = <unknown>.getServletConfig()###<unknown>.getServletContext();
        javax.servlet.ServletResponse.setContentType(java.lang.String)
        javax.servlet.ServletResponse.setContentLength(int)
        javax.servlet.http.HttpServletResponse.setHeader(java.lang.String,java.lang.String)
        byte[] bbuf = new byte[1024];
        java.io.DataInputStream in = new java.io.DataInputStream(new java.io.FileInputStream(f));
        while ((in != null) && ((length = java.io.DataInputStream.read(byte[])) != (-1))) {
          java.io.OutputStream.write(byte[],int,int)
        } 
        java.io.FilterInputStream.close()
        java.io.OutputStream.flush()
        java.io.OutputStream.close()
      } catch (java.lang.Exception ex) {
        java.lang.Throwable.printStackTrace()
      }
      return "Server says: " + filename;
    }
  }
}
