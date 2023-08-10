public class hibernate_class_5 {
    private static final org.hibernate.SessionFactory sessionFactory = hibernate.hibernate_class_5.buildSessionFactory();

    private static org.hibernate.SessionFactory buildSessionFactory() {
        try {
            return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        } catch (java.lang.Throwable ex) {
            java.lang.System.err.println("Initial SessionFactory creation failed." + ex);
            throw new java.lang.ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        return hibernate.hibernate_class_5.sessionFactory;
    }
}

