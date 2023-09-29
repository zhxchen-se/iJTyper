public class hibernate_class_22 {
    public com.google.gwt.thirdparty.json.JSONObject check() {
        org.hibernate.Session session = null;
        com.google.gwt.thirdparty.json.JSONObject check = new com.google.gwt.thirdparty.json.JSONObject();
        try {
            org.hibernate.SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            java.lang.String username = null;
            boolean justusername = false;
            if (justusername) {
                java.lang.String hquery = "Select username from User user Where username = ? ";
                org.hibernate.Query query = session.createQuery(hquery);
                query.setString(0, username);
                java.lang.String user = ((java.lang.String) (query.uniqueResult()));
                if (user == null) {
                    check.put("indatabase", "false");
                } else {
                    check.put("indatabase", "true");
                }
                check.put("justusername", true);
            } else {
                java.lang.String hquery = "Select username from User user Where username = :user and password = :pass ";
                org.hibernate.Query query = session.createQuery(hquery);
                query.setString("user", username);
                java.lang.String password = null;
                query.setString("pass", password);
                java.lang.String user = ((java.lang.String) (query.uniqueResult()));
                if (user == null) {
                    check.put("indatabase", false);
                } else {
                    check.put("indatabase", true);
                }
                check.put("justusername", false);
            }
        } catch (java.lang.Exception e) {
            java.lang.System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
        return check;
    }
}

