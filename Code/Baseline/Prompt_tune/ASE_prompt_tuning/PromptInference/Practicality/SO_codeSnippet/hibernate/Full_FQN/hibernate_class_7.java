public class hibernate_class_7 {
  public class HibernateUtils {
    private final org.hibernate.SessionFactory sessionFactory;

    private org.hibernate.Session session;

    public HibernateUtils() {
      this.sessionFactory = org.hibernate.cfg.AnnotationConfiguration.configure()###<unknown>.buildSessionFactory();
    }

    public HibernateUtils(org.hibernate.SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
    }

    /**
     * this is the function that return a session.So i'm free to implements any type of session in here.
     */
    public org.hibernate.Session requestSession() {
      // if (session != null || session.isOpen()) {
      // return session;
      // } else {
      session = org.hibernate.SessionFactory.openSession();
      // }
      return session;
    }
  }
}
