public class hibernate_class_23 {
    private static final java.lang.ThreadLocal<org.hibernate.Session> threadLocal = new java.lang.ThreadLocal<org.hibernate.Session>();

    private static org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.AnnotationConfiguration();

    private static org.hibernate.SessionFactory sessionFactory;

    static {
        try {
            java.lang.String configFile = "";
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (java.lang.Exception e) {
        }
    }

    private hibernate_class_23() {
    }

    public static org.hibernate.Session getSession() throws org.hibernate.HibernateException {
        org.hibernate.Session session = ((org.hibernate.Session) (hibernate.hibernate_class_23.threadLocal.get()));
        if ((session == null) || (!session.isOpen())) {
            if (hibernate.hibernate_class_23.sessionFactory == null) {
            }
            session = (hibernate.hibernate_class_23.sessionFactory != null) ? hibernate.hibernate_class_23.sessionFactory.openSession() : null;
            hibernate.hibernate_class_23.threadLocal.set(session);
        }
        return session;
    }
}

