public class ad8 {
    public static void setLocale(android.app.Activity activity, java.lang.String languageCode) {
        java.util.Locale locale = new java.util.Locale(languageCode);
        java.util.Locale.setDefault(locale);
        android.content.res.Resources resources = activity.getResources();
    }
}

