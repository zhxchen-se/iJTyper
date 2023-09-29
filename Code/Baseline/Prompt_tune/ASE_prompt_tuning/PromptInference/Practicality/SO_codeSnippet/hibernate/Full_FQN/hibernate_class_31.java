public class hibernate_class_31 {
  public static java.util.List<?> getData() {
    org.hibernate.SessionFactory sessionFactory = org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
    org.hibernate.Session session = org.hibernate.SessionFactory.getCurrentSession();
    java.util.List<?> result = null;
    try {
      org.hibernate.Session.beginTransaction()
      Query query = org.hibernate.Session.createQuery(java.lang.String);
      result = Query.list();
      org.hibernate.Session.getTransaction()###<unknown>.commit()
      Query.setReadOnly(boolean)
      Query.setMaxResults(int)
      org.hibernate.Session.flush()
      org.hibernate.Session.close()
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
    }
    return result;
  }
}
