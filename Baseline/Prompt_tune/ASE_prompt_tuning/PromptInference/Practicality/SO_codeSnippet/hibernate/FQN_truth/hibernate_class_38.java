public class hibernate_class_38 {
    public static void main(java.lang.String... args) {
        org.hibernate.SessionFactory sessionFact = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        org.hibernate.Session ses = sessionFact.openSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        java.lang.String bean = "";
        ses.save(bean);
        tx.commit();
        ses.close();
    }
}

