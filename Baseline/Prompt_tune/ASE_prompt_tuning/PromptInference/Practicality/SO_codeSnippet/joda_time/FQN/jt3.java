public class jt3 {
    public static void f1() {
        java.time.LocalDateTime java8LocalDateTime = java.time.LocalDateTime.now();
        java.time.ZonedDateTime java8ZonedDateTime = java8LocalDateTime.atZone(java.time.ZoneId.systemDefault());
        java.time.Instant java8Instant = java8ZonedDateTime.toInstant();
    }
}

