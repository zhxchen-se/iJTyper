public class hb6 {
    public static void h1() {
        org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration().configure();
        org.hibernate.SessionFactory sessionFactory = config.buildSessionFactory();
    }
}

