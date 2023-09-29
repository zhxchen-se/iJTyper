public class hibernate_class_33 {
    private static hibernate_class_33 instance = null;

    private org.hibernate.SessionFactory sessionFactory;

    public static hibernate_class_33 getInstance() {
        if (hibernate_class_33.instance == null) {
            hibernate_class_33.instance = new hibernate_class_33().init();
        }
        return hibernate_class_33.instance;
    }

    public org.hibernate.SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public org.hibernate.Session getSession() {
        return this.sessionFactory.openSession();
    }

    private hibernate_class_33 init() {
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
        // cfg.addClass(domain.UserClass.class);
        // cfg.addClass(domain.User.class);
        cfg.setProperties(java.lang.System.getProperties());
        cfg.configure();
        org.hibernate.SessionFactory sessions = cfg.buildSessionFactory();
        sessionFactory = cfg.configure().buildSessionFactory();
        return this;
    }
}

