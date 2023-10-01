public class hibernate_class_37 {
  public static void test() {
    java.lang.String c = "";
    org.hibernate.Session session = hibernate_class_37$HibernateUtil.getSession();
    org.hibernate.Session.beginTransaction()
    org.hibernate.Session.save(java.lang.String)
    org.hibernate.Session.getTransaction()###<unknown>.commit()
  }

  /**
   *
   *
   * @param args
   * 		
   */
  public static void main(java.lang.String[] args) {
    hibernate_class_37.test()
  }

  public static class HibernateUtil {
    private static final org.hibernate.SessionFactory sessionFactory;

    static {
      try {
        hibernate_class_37.HibernateUtil.sessionFactory = org.hibernate.cfg.AnnotationConfiguration.configure()###<unknown>.buildSessionFactory();
      } catch (java.lang.Throwable ex) {
        // Log exception!
        throw new java.lang.ExceptionInInitializerError(ex);
      }
    }

    public static org.hibernate.Session getSession() throws org.hibernate.HibernateException {
      return org.hibernate.SessionFactory.openSession();
    }
  }
}
