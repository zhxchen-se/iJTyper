public class hibernate_class_20 {
  private static final org.hibernate.SessionFactory sessionFactory;

  static {
    try {
      // Create the SessionFactory from hibernate.cfg.xml
      hibernate_class_20.sessionFactory = org.hibernate.cfg.AnnotationConfiguration.configure()###<unknown>.buildSessionFactory();
    } catch (java.lang.Throwable e) {
      java.io.PrintStream.println(java.lang.String)
      throw new java.lang.ExceptionInInitializerError(e);
    }
  }

  public static org.hibernate.SessionFactory getSessionFactory() {
    return hibernate_class_20.sessionFactory;
  }
}
