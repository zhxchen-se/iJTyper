public class JodaTime09 {
    public static void main(java.lang.String[] args) {
        final java.lang.String string_from_3rd_party = "GMT+08:00";
        java.lang.System.out.println(java.util.TimeZone.getTimeZone(string_from_3rd_party));
        java.lang.System.out.println(org.joda.time.DateTimeZone.forID(string_from_3rd_party));
    }
}

