// ID = 442496
public class Android08 {
    private static final java.lang.String TAG = "TAG";

    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        try {
            java.net.InetAddress server = java.net.Inet4Address.getByName("thehost");
            // Doesn't work either
            // or InetAddress server2 = Inet4Address.getByAddress(new String("192.168.1.30").getBytes());
            if (server.isReachable(5000)) {
                android.util.Log.d(androidExamples.Android08.TAG, "Ping!");
            }
            java.net.Socket clientsocket = new java.net.Socket(server, 8080);
        } catch (java.net.UnknownHostException e) {
            android.util.Log.e(androidExamples.Android08.TAG, "Server Not Found");
        } catch (java.io.IOException e) {
            android.util.Log.e(androidExamples.Android08.TAG, "Couldn't open socket");
        }
    }
}

