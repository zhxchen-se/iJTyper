public class hibernate_class_23 {
  private static final java.lang.ThreadLocal<org.hibernate.Session> threadLocal = new java.lang.ThreadLocal<org.hibernate.Session>();

  private static org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.AnnotationConfiguration();

  private static org.hibernate.SessionFactory sessionFactory;

  static {
    try {
      java.lang.String configFile = "";
      org.hibernate.cfg.Configuration.configure(java.lang.String)
      hibernate_class_23.sessionFactory = org.hibernate.cfg.Configuration.buildSessionFactory();
    } catch (java.lang.Exception e) {
    }
  }

  private hibernate_class_23() {
  }

  public static org.hibernate.Session getSession() throws org.hibernate.HibernateException {
    org.hibernate.Session session = java.lang.ThreadLocal.get();
    if ((session == null) || (!org.hibernate.Session.isOpen())) {
      if (hibernate_class_23.sessionFactory == null) {
        // rebuildSessionFactory();//This method basically does what the static init block does
      }
      session = (hibernate_class_23.sessionFactory != null) ? org.hibernate.SessionFactory.openSession() : null;
      java.lang.ThreadLocal.set(org.hibernate.Session)
    }
    return session;
  }
}
