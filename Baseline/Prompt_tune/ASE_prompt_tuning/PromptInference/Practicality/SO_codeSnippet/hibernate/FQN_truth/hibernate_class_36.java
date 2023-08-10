public class hibernate_class_36 {
    public static void main(java.lang.String[] args) {
        org.hibernate.Session session = null;
        org.hibernate.SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        org.hibernate.Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            tx.commit();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

