public abstract class hibernate_class_48 extends net.sf.gilead.gwt.PersistentRemoteService implements aQute.gwt.greeter.shared.GreetingService {
    private static final long serialVersionUID = 1L;

    private net.sf.gilead.core.hibernate.HibernateUtil gileadHibernateUtil = new net.sf.gilead.core.hibernate.HibernateUtil();

    public hibernate_class_48() {
        org.hibernate.SessionFactory session = null;
        gileadHibernateUtil.setSessionFactory(session);
        net.sf.gilead.core.PersistentBeanManager persistentBeanManager = new net.sf.gilead.core.PersistentBeanManager();
        persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
        persistentBeanManager.setProxyStore(new net.sf.gilead.core.store.stateless.StatelessProxyStore());
        setBeanManager(persistentBeanManager);
    }

    public java.lang.String greetServer(java.lang.String S) {
        org.hibernate.Session session = gileadHibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        session.save(S);
        tr.commit();
        session.close();
        return S;
    }
}

