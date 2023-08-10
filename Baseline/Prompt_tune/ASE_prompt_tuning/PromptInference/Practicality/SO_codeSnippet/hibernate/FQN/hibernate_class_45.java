public class hibernate_class_45 {
    public static void main(java.lang.String[] args) {
        org.hibernate.SessionFactory factory = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
        org.hibernate.Session session = factory.openSession();
        session.beginTransaction();
        // Message m1 = new Message("Hibernated a  messages on " + new Date());
        session.save("aa");
        session.getTransaction().commit();
        session.close();
    }
}

