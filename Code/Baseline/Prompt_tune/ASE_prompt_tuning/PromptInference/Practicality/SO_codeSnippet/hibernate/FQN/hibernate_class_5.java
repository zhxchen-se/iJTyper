public class hibernate_class_5 {
    private static final org.hibernate.SessionFactory sessionFactory = hibernate_class_5.buildSessionFactory();

    private static org.hibernate.SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        } catch (java.lang.Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            java.lang.System.err.println("Initial SessionFactory creation failed." + ex);
            throw new java.lang.ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        return hibernate_class_5.sessionFactory;
    }
}

