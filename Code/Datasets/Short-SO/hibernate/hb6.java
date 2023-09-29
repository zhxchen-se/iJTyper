package java.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hb6 {
    public static  void h1(){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
    }
}
