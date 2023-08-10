public class hibernate_class_43 {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(hibernate_class_43.class);

    private static org.hibernate.SessionFactory sessionFactory;

    private static java.lang.String confFile = "hibernate-test.properties";

    private static final java.lang.ThreadLocal<org.hibernate.Session> threadSession = new java.lang.ThreadLocal<org.hibernate.Session>();

    private hibernate_class_43() {
    }

    public static void buildSessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        synchronized(hibernate_class_43.class) {
            if (hibernate_class_43.sessionFactory == null) {
                try {
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(hibernate_class_43.class.getClassLoader().getResourceAsStream(hibernate_class_43.confFile));
                    configuration.setProperties(properties);
                } catch (java.lang.Exception e) {
                    hibernate_class_43.log.fatal("cannot load the specified hibernate properties file: " + hibernate_class_43.confFile);
                    throw new java.lang.RuntimeException("cannot load the specified hibernate properties file : " + hibernate_class_43.confFile, e);
                }
                hibernate_class_43.sessionFactory = configuration.configure().buildSessionFactory();
            }
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        if (hibernate_class_43.sessionFactory == null) {
            hibernate_class_43.buildSessionFactory();
        }
        return hibernate_class_43.sessionFactory;
    }

    public static org.hibernate.Session getCurrentSession() {
        if (!hibernate_class_43.getSessionFactory().getCurrentSession().isOpen()) {
            hibernate_class_43.getSessionFactory().openSession();
        }
        return hibernate_class_43.getSessionFactory().getCurrentSession();
    }
}

