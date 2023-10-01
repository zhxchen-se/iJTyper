
//ID = 4346254
import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.core.hibernate.HibernateUtil;
import net.sf.gilead.core.store.stateless.StatelessProxyStore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


//import aQute.gwt.greeter.shared.GreetingService;
public abstract class hibernate_class_48{

    private static final long serialVersionUID = 1L;
    private HibernateUtil gileadHibernateUtil = new HibernateUtil();
    public hibernate_class_48 ()
    {
    	SessionFactory session = null;
         gileadHibernateUtil.setSessionFactory(session);

                PersistentBeanManager persistentBeanManager = new PersistentBeanManager();
                persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
                persistentBeanManager.setProxyStore(new StatelessProxyStore());

    }

    public String greetServer(String S) 
    {
        Session session = gileadHibernateUtil.getSessionFactory().openSession();
        Transaction tr= session.beginTransaction();
        session.save(S);
        tr.commit();
        session.close();
         return S;
      }


}
