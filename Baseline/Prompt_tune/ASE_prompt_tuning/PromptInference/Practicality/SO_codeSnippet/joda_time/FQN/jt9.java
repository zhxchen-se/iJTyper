public class jt9 {
    public static void h1() {
        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.ZonedDateTime zdt = today.atStartOfDay().atZone(java.time.ZoneId.systemDefault());
        java.time.OffsetDateTime odt = zdt.toOffsetDateTime();
    }
}

