public class hibernate_class_31 {
    public static java.util.List<?> getData() {
        org.hibernate.SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        java.util.List<?> result = null;
        try {
            session.beginTransaction();
            org.hibernate.Query query = session.createQuery("from Users");
            result = query.list();
            session.getTransaction().commit();
            query.setReadOnly(true);
            query.setMaxResults(50);
            session.flush();
            session.close();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

