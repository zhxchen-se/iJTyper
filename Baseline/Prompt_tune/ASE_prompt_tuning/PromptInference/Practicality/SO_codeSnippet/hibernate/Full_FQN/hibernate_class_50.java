public class hibernate_class_50 {
  private org.hibernate.SessionFactory sessionFactory;

  public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public org.hibernate.SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  @java.lang.SuppressWarnings("unchecked")
  public java.util.List<java.util.jar.Attributes.Name> getAll() {
    org.hibernate.Session session = org.hibernate.SessionFactory.getCurrentSession();
    java.util.List<java.util.jar.Attributes.Name> names = org.hibernate.Session.createQuery(java.lang.String)###<unknown>.list();
    return names;
  }

  public void save(java.util.jar.Attributes.Name name) {
    org.hibernate.Session session = org.hibernate.SessionFactory.getCurrentSession();
    org.hibernate.Session.saveOrUpdate(java.util.jar.Attributes$Name)
    org.hibernate.Session.flush()
  }
}
