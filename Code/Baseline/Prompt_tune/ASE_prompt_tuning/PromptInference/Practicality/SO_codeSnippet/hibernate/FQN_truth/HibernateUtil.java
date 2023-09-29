public class HibernateUtil {
    private static final org.hibernate.SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
        } catch (java.lang.Throwable e) {
            java.lang.System.err.println("Initial sessionFactory creation failed.  " + e);
            throw new java.lang.ExceptionInInitializerError(e);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        return hibernate.HibernateUtil.sessionFactory;
    }
}

