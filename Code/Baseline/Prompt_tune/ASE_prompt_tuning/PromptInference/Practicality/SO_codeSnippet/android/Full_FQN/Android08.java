// ID = 442496
public class Android08 {
  private static final java.lang.String TAG = "TAG";

  public static void main(java.lang.String[] args) {
    // TODO Auto-generated method stub
    try {
      java.net.InetAddress server = java.net.InetAddress.getByName(java.lang.String);
      // Doesn't work either
      // or InetAddress server2 = Inet4Address.getByAddress(new String("192.168.1.30").getBytes());
      if (java.net.InetAddress.isReachable(int)) {
        android.util.Log.d(java.lang.String,java.lang.String)
      }
      java.net.Socket clientsocket = new java.net.Socket(server, 8080);
    } catch (java.net.UnknownHostException e) {
      android.util.Log.e(java.lang.String,java.lang.String)
    } catch (java.io.IOException e) {
      android.util.Log.e(java.lang.String,java.lang.String)
    }
  }
}
