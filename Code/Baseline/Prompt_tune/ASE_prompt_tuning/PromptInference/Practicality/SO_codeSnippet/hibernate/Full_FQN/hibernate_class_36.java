public class hibernate_class_36 {
  public static void main(java.lang.String[] args) {
    org.hibernate.Session session = null;
    org.hibernate.SessionFactory sessionFactory = org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
    // MyClass str1 = null;
    org.hibernate.Transaction tx = null;
    try {
      session = org.hibernate.SessionFactory.openSession();
      tx = org.hibernate.Session.beginTransaction();
      org.hibernate.Transaction.commit()
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
    } finally {
      org.hibernate.Session.close()
    }
  }
}
