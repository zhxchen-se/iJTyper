public class hibernate_class_18 {
    private static final org.hibernate.SessionFactory sessionFactory = hibernate_class_18.buildSessionFactory();

    private static org.hibernate.SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure();
            return configuration.buildSessionFactory();
        } catch (java.lang.Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            java.lang.System.err.println("Initial SessionFactory creation failed." + ex);
            throw new java.lang.ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory1() {
        return hibernate_class_18.sessionFactory;
    }

    private static final org.hibernate.SessionFactory sessionFactory1 = hibernate_class_18.buildSessionFactory();

    private static org.hibernate.SessionFactory buildSessionFactory1() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure();
            return configuration.buildSessionFactory();
        } catch (java.lang.Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            java.lang.System.err.println("Initial SessionFactory creation failed." + ex);
            throw new java.lang.ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        return hibernate_class_18.sessionFactory;
    }
}

