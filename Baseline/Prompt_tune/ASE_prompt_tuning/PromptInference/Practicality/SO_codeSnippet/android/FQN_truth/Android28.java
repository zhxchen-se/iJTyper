public class Android28 extends android.app.Application {
    private static android.Android28 instance;

    public Android28() {
        android.Android28.instance = this;
    }

    public static javax.naming.Context getContext() {
        return ((javax.naming.Context) (android.Android28.instance));
    }
}

