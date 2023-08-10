public class hibernate_class_4 {
    private static final org.hibernate.SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        } catch (org.hibernate.HibernateException he) {
            java.lang.System.err.println(he);
            throw new java.lang.ExceptionInInitializerError(he);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        return hibernate_class_4.sessionFactory;
    }
}

