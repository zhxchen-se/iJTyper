public class jt19 {
    public static void h1() {
        java.lang.String input = "04/02/2011 20:27:05";
        java.time.format.DateTimeFormatter f = java.time.format.DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        java.time.LocalDateTime ldt = java.time.LocalDateTime.parse(input, f);
    }
}

