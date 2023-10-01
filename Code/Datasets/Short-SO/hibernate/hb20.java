package java.hibernate;

import android.app.FragmentManager;
import net.sf.gilead.core.hibernate.HibernateUtil;
import org.hibernate.Transaction;

public class hb20 {
    private static HibernateUtil HibernateUtils;

    public static void h1(){
        Transaction tx = null;
        FragmentManager session = null;
        tx = (Transaction) session.beginTransaction();

    }
}
