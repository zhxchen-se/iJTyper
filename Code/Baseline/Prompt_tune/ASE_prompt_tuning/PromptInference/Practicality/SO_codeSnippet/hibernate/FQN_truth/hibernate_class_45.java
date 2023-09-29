public class hibernate_class_45 {
    public static void main(java.lang.String[] args) {
        org.hibernate.SessionFactory factory = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
        org.hibernate.Session session = factory.openSession();
        session.beginTransaction();
        session.save("aa");
        session.getTransaction().commit();
        session.close();
    }
}

