public class hibernate_class_5 {
  private static final org.hibernate.SessionFactory sessionFactory = hibernate_class_5.buildSessionFactory();

  private static org.hibernate.SessionFactory buildSessionFactory() {
    try {
      // Create the SessionFactory from hibernate.cfg.xml
      return org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
    } catch (java.lang.Throwable ex) {
      java.io.PrintStream.println(java.lang.String)
      throw new java.lang.ExceptionInInitializerError(ex);
    }
  }

  public static org.hibernate.SessionFactory getSessionFactory() {
    return hibernate_class_5.sessionFactory;
  }
}
