
//ID = 4302983
import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class hibernate_class_46{

	public static final ThreadLocal session = new ThreadLocal();
	private static hibernate_class_46 me;

	static {
	    try {
	        me = new hibernate_class_46();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private hibernate_class_46() throws HibernateException, JDBCException {
	}

	public Session currentSession() throws Exception {
	    Session s = (Session) session.get();
	    if (s != null) {
	        s.setCacheMode(CacheMode.REFRESH);
	    }

	    if (s == null) {
	        s =openSession();

	        session.set(s);
	    }

	    return s;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
	}

	public static Session openSession() {
	    Session session = null;
	    return session;
	}
}