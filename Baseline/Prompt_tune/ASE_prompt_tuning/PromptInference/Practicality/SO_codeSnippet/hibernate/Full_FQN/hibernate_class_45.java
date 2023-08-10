public class hibernate_class_45 {
  public static void main(java.lang.String[] args) {
    org.hibernate.SessionFactory factory = org.hibernate.cfg.AnnotationConfiguration.configure()###<unknown>.buildSessionFactory();
    org.hibernate.Session session = org.hibernate.SessionFactory.openSession();
    org.hibernate.Session.beginTransaction()
    org.hibernate.Session.save(java.lang.String)
    org.hibernate.Session.getTransaction()###<unknown>.commit()
    org.hibernate.Session.close()
  }
}
