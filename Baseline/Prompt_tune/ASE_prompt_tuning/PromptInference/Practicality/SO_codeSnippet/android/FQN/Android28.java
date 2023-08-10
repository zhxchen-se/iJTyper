public class Android28 extends android.app.Application {
    private static androidExamples.Android28 instance;

    public Android28() {
        androidExamples.Android28.instance = this;
    }

    public static android.content.Context getContext() {
        return androidExamples.Android28.instance;
    }
}

