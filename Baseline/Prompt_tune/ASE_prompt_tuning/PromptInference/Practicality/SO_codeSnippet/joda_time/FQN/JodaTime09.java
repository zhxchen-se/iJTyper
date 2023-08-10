// ID = 4057816
public class JodaTime09 {
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
        final java.lang.String string_from_3rd_party = "GMT+08:00";
        // Works for standard Java TimeZone!
        java.lang.System.out.println(java.util.TimeZone.getTimeZone(string_from_3rd_party));
        // Exception in thread "main" java.lang.IllegalArgumentException: The datetime zone id is not recognised: GMT+08:00
        java.lang.System.out.println(org.joda.time.DateTimeZone.forID(string_from_3rd_party));
    }
}

