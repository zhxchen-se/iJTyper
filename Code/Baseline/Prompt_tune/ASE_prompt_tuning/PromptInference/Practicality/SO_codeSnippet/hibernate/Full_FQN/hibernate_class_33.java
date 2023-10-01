public class hibernate_class_33 {
  private static hibernate_class_33 instance = null;

  private org.hibernate.SessionFactory sessionFactory;

  public static hibernate_class_33 getInstance() {
    if (hibernate_class_33.instance == null) {
      hibernate_class_33.instance = hibernate_class_33.init();
    }
    return hibernate_class_33.instance;
  }

  public org.hibernate.SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  public org.hibernate.Session getSession() {
    return org.hibernate.SessionFactory.openSession();
  }

  private hibernate_class_33 init() {
    org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
    org.hibernate.cfg.Configuration.setProperties(java.util.Properties)
    org.hibernate.cfg.Configuration.configure()
    org.hibernate.SessionFactory sessions = org.hibernate.cfg.Configuration.buildSessionFactory();
    sessionFactory = org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
    return this;
  }
}
