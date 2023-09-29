public class hibernate_class_38 {
  public static void main(java.lang.String... args) {
    org.hibernate.SessionFactory sessionFact = org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
    org.hibernate.Session ses = org.hibernate.SessionFactory.openSession();
    org.hibernate.Transaction tx = org.hibernate.Session.beginTransaction();
    java.lang.String bean = "";
    org.hibernate.Session.save(java.lang.String)
    org.hibernate.Transaction.commit()
    org.hibernate.Session.close()
  }
}
