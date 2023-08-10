
//ID = 3509824
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class hibernate_class_35 {    
	public static void main(String[] args) {
	    BasicConfigurator.configure();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    try {
	        transaction = session.beginTransaction();
//	        Label label = new Label("vijay");
	        Query query=session.createQuery("from vij");
	        List list=query.list();
	            for (Iterator it=list.iterator();it.hasNext();)
	        {
//	            System.out.println(label.getId());          
	        }
	            transaction.commit();

	    } catch (HibernateException e) {

	        if (transaction != null) {
	              transaction.rollback();
	                        }
	                    e.printStackTrace();
	    } finally {
	        session.close();
	    }

	}
}