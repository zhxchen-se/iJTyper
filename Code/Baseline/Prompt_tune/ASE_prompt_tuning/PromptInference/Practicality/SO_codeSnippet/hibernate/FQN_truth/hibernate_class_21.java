public class hibernate_class_21 {
    public static void main(java.lang.String[] args) {
        org.hibernate.Session session = null;
        org.hibernate.SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            transaction.commit();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

