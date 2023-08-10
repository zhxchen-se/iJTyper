public class hibernate_class_12 {
  public void main() {
    org.hibernate.Session session = null;
    try {
      org.hibernate.SessionFactory sessionFactory = org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
      session = org.hibernate.SessionFactory.openSession();
      java.lang.String id = javax.faces.context.FacesContext.getCurrentInstance()###<unknown>.getExternalContext()###<unknown>.getRequestParameterMap()###<unknown>.get(java.lang.String);
      org.hibernate.Transaction t = org.hibernate.Session.beginTransaction();
      org.hibernate.Transaction.commit()
    } catch (java.lang.Exception e) {
    } finally {
      org.hibernate.Session.close()
    }
  }
}
