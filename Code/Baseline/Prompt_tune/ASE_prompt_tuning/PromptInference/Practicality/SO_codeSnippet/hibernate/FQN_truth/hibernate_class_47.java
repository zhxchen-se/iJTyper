public class hibernate_class_47 {
    public static boolean registerEvent() {
        org.hibernate.SessionFactory sf = hibernate.HibernateUtil.getSessionFactory();
        org.hibernate.Transaction t = null;
        try {
            org.hibernate.Session s = sf.openSession();
            t = s.beginTransaction();
            s.persist("aa");
            t.commit();
            return true;
        } catch (java.lang.Exception ex) {
            java.lang.System.err.println("Error -->" + ex.getMessage());
            if (t != null) {
                t.rollback();
            }
            return false;
        }
    }
}

