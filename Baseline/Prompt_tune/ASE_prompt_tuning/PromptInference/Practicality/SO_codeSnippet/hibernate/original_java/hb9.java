package java.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.TransactionException;

public class hb9 {
    public static void h1() throws HibernateException {
        boolean begun = false;
        if (!begun) {
            throw new TransactionException("Transaction not successfully started");
        }
    }
}
