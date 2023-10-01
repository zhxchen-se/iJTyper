public class hibernate_class_33 {
    private static hibernate.hibernate_class_33 instance = null;

    private org.hibernate.SessionFactory sessionFactory;

    public static hibernate.hibernate_class_33 getInstance() {
        if (hibernate.hibernate_class_33.instance == null) {
            hibernate.hibernate_class_33.instance = new hibernate.hibernate_class_33().init();
        }
        return hibernate.hibernate_class_33.instance;
    }

    public org.hibernate.SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public org.hibernate.Session getSession() {
        return this.sessionFactory.openSession();
    }

    private hibernate.hibernate_class_33 init() {
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
        cfg.setProperties(java.lang.System.getProperties());
        cfg.configure();
        org.hibernate.SessionFactory sessions = cfg.buildSessionFactory();
        sessionFactory = cfg.configure().buildSessionFactory();
        return this;
    }
}

