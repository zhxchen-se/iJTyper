public class hb7 {
  public static void h1() {
    org.hibernate.cfg.Configuration config = org.hibernate.cfg.Configuration.configure();
    org.hibernate.SessionFactory sessionFactory = org.hibernate.cfg.Configuration.buildSessionFactory();
    org.hibernate.Session session = org.hibernate.SessionFactory.openSession();
  }
}
