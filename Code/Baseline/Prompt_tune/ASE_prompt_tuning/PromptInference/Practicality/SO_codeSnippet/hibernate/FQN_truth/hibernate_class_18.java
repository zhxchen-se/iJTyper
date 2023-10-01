public class hibernate_class_18 {
    private static final org.hibernate.SessionFactory sessionFactory = hibernate.hibernate_class_18.buildSessionFactory();

    private static org.hibernate.SessionFactory buildSessionFactory() {
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure();
            return configuration.buildSessionFactory();
        } catch (java.lang.Throwable ex) {
            java.lang.System.err.println("Initial SessionFactory creation failed." + ex);
            throw new java.lang.ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory1() {
        return hibernate.hibernate_class_18.sessionFactory;
    }

    private static final org.hibernate.SessionFactory sessionFactory1 = hibernate.hibernate_class_18.buildSessionFactory();

    private static org.hibernate.SessionFactory buildSessionFactory1() {
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure();
            return configuration.buildSessionFactory();
        } catch (java.lang.Throwable ex) {
            java.lang.System.err.println("Initial SessionFactory creation failed." + ex);
            throw new java.lang.ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        return hibernate.hibernate_class_18.sessionFactory;
    }
}

