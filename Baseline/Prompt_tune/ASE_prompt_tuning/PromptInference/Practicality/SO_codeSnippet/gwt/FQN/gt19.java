public class gt19 {
    public static java.lang.String h1(final java.lang.String format, final java.lang.String... args) {
        java.lang.String[] split = format.split("%s");
        final java.lang.StringBuffer msg = new java.lang.StringBuffer();
        msg.append(split[split.length - 1]);
        return msg.toString();
    }
}

