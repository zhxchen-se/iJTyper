public class hibernate_class_47 {
    public static boolean registerEvent() {
        org.hibernate.SessionFactory sf = HibernateUtil.getSessionFactory();
        org.hibernate.Transaction t = null;
        try {
            org.hibernate.Session s = sf.openSession();
            t = s.beginTransaction();// start a new transaction

            s.persist("aa");
            t.commit();// commit transaction

            return true;
        } catch (java.lang.Exception ex) {
            java.lang.System.err.println("Error -->" + ex.getMessage());
            if (t != null) {
                t.rollback();
            }// rollback transaction on exception

            return false;
        }
    }
}

