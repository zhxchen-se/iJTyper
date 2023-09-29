public class HibernateUtil {
  private static final org.hibernate.SessionFactory sessionFactory;

  static {
    try {
      // Create the SessionFactory from hibernate.cfg.xml
      HibernateUtil.sessionFactory = org.hibernate.cfg.AnnotationConfiguration.configure()###<unknown>.buildSessionFactory();
    } catch (java.lang.Throwable e) {
      java.io.PrintStream.println(java.lang.String)
      throw new java.lang.ExceptionInInitializerError(e);
    }
  }

  public static org.hibernate.SessionFactory getSessionFactory() {
    return HibernateUtil.sessionFactory;
  }
}
