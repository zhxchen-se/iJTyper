public class gt8 {
    public java.util.Date parse(java.lang.String dateString) {
        try {
            return new java.text.SimpleDateFormat("yyyyMMdd").parse(dateString);
        } catch (java.lang.Exception ex) {
            throw new java.lang.IllegalArgumentException("Cannot convert to date: " + dateString);
        }
    }
}

