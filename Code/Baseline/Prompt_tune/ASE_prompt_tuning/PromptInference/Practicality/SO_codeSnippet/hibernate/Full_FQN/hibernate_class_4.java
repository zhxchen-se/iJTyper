public class hibernate_class_4 {
  private static final org.hibernate.SessionFactory sessionFactory;

  static {
    try {
      hibernate_class_4.sessionFactory = org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
    } catch (org.hibernate.HibernateException he) {
      java.io.PrintStream.println(char[])
      throw new java.lang.ExceptionInInitializerError(he);
    }
  }

  public static org.hibernate.SessionFactory getSessionFactory() {
    return hibernate_class_4.sessionFactory;
  }
}
