public abstract class hibernate_class_29<T> {
  private java.lang.Class<T> domainClass;

  private org.hibernate.SessionFactory sf;

  public hibernate_class_29(java.lang.Class<T> domainClass) {
    this.domainClass = domainClass;
  }

  public org.hibernate.SessionFactory getSessionFactory() {
    return sf;
  }

  public void setSessionFactory(org.hibernate.SessionFactory sf) {
    this.sf = sf;
  }

  public void delete(T object) {
    hibernate_class_29.getSession()###org.hibernate.Session.delete(java.lang.Object)
  }

  @java.lang.SuppressWarnings("unchecked")
  public T load(long id) {
    return hibernate_class_29.getSession()###org.hibernate.Session.get(java.lang.Class,long);
  }

  public void save(T object) {
    hibernate_class_29.getSession()###org.hibernate.Session.saveOrUpdate(java.lang.Object)
  }

  @java.lang.SuppressWarnings("unchecked")
  public java.util.List<T> findAll() {
    org.hibernate.Criteria criteria = hibernate_class_29.getSession()###org.hibernate.Session.createCriteria(java.lang.Class);
    java.util.List<T> r = org.hibernate.Criteria.list();
    return r;
  }

  public int countAll() {
    org.hibernate.Criteria criteria = hibernate_class_29.getSession()###org.hibernate.Session.createCriteria(java.lang.Class);
    org.hibernate.Criteria.setProjection()
    return org.hibernate.Criteria.uniqueResult();
  }

  public org.hibernate.Session getSession() {
    // presumes a current session, which we have through the
    // OpenSessionInViewFilter; doesn't work without that
    return org.hibernate.SessionFactory.getCurrentSession();
  }
}
