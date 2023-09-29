// import aQute.gwt.greeter.shared.GreetingService;
public abstract class hibernate_class_48 {
  private static final long serialVersionUID = 1L;

  private net.sf.gilead.core.hibernate.HibernateUtil gileadHibernateUtil = new net.sf.gilead.core.hibernate.HibernateUtil();

  public hibernate_class_48() {
    org.hibernate.SessionFactory session = null;
    net.sf.gilead.core.hibernate.HibernateUtil.setSessionFactory(org.hibernate.SessionFactory)
    net.sf.gilead.core.PersistentBeanManager persistentBeanManager = new net.sf.gilead.core.PersistentBeanManager();
    net.sf.gilead.core.PersistentBeanManager.setPersistenceUtil(net.sf.gilead.core.hibernate.HibernateUtil)
    net.sf.gilead.core.PersistentBeanManager.setProxyStore(net.sf.gilead.core.store.stateless.StatelessProxyStore)
  }

  public java.lang.String greetServer(java.lang.String S) {
    org.hibernate.Session session = net.sf.gilead.core.hibernate.HibernateUtil.getSessionFactory()###<unknown>.openSession();
    org.hibernate.Transaction tr = org.hibernate.Session.beginTransaction();
    org.hibernate.Session.save(java.lang.String)
    org.hibernate.Transaction.commit()
    org.hibernate.Session.close()
    return S;
  }
}
