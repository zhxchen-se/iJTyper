public class hibernate_class_37 {
    public static void test() {
        java.lang.String c = "";
        org.hibernate.Session session = hibernate.hibernate_class_37.HibernateUtil.getSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
    }

    public static void main(java.lang.String[] args) {
        hibernate.hibernate_class_37.test();
    }

    public static class HibernateUtil {
        private static final org.hibernate.SessionFactory sessionFactory;

        static {
            try {
                sessionFactory = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
            } catch (java.lang.Throwable ex) {
                throw new java.lang.ExceptionInInitializerError(ex);
            }
        }

        public static org.hibernate.Session getSession() throws org.hibernate.HibernateException {
            return hibernate.hibernate_class_37.HibernateUtil.sessionFactory.openSession();
        }
    }
}

