public class hibernate_class_35 {
    public static void main(java.lang.String[] args) {
        org.apache.log4j.BasicConfigurator.configure();
        org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            // Label label = new Label("vijay");
            org.hibernate.Query query = session.createQuery("from vij");
            java.util.List list = query.list();
            for (java.util.Iterator it = list.iterator(); it.hasNext();) {
                // System.out.println(label.getId());
            }
            transaction.commit();
        } catch (org.hibernate.HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

