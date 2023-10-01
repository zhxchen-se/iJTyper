public class jdk9 {
    public static void h1() {
        java.time.format.DateTimeFormatter DATE_FORMAT = new java.time.format.DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy[ [HH][:mm][:ss][.SSS]]").parseDefaulting(java.time.temporal.ChronoField.HOUR_OF_DAY, 0).parseDefaulting(java.time.temporal.ChronoField.MINUTE_OF_HOUR, 0).parseDefaulting(java.time.temporal.ChronoField.SECOND_OF_MINUTE, 0).toFormatter();
    }
}

