public class hibernate_class_21 {
    public static void main(java.lang.String[] args) {
        org.hibernate.Session session = null;
        org.hibernate.SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.getTransaction();
        // BusinessCard card = new BusinessCard();
        // card.setId(1);
        // card.setName("zgr");
        // card.setDescription("Ac?klama");
        try {
            transaction.begin();
            // session.save();
            transaction.commit();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

