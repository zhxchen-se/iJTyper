public class hibernate_class_46 {
    public static final java.lang.ThreadLocal session = new java.lang.ThreadLocal();

    private static hibernate_class_46 me;

    static {
        try {
            me = new hibernate_class_46();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private hibernate_class_46() throws org.hibernate.HibernateException, org.hibernate.JDBCException {
    }

    public org.hibernate.Session currentSession() throws java.lang.Exception {
        org.hibernate.Session s = ((org.hibernate.Session) (hibernate_class_46.session.get()));
        if (s != null) {
            s.setCacheMode(CacheMode.REFRESH);
        }
        if (s == null) {
            s = hibernate_class_46.openSession();
            hibernate_class_46.session.set(s);
        }
        return s;
    }

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
    }

    public static org.hibernate.Session openSession() {
        org.hibernate.Session session = null;
        return session;
    }
}

