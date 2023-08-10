public class JodaTime12 {
    public static void main(java.lang.String[] args) {
        java.lang.String currentDate;
        java.text.SimpleDateFormat myFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
        java.sql.Date date1 = null;
        org.joda.time.DateTime dt;
        currentDate = "27/12/2010 11:29";
        try {
            date1 = ((java.sql.Date) (myFormat.parse(currentDate)));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dt = new org.joda.time.DateTime(date1);
        dt.plusMinutes(30);
    }
}

