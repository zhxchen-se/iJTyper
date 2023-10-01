public class hibernate_class_7 {
    public class HibernateUtils {
        private final org.hibernate.SessionFactory sessionFactory;

        private org.hibernate.Session session;

        public HibernateUtils() {
            this.sessionFactory = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
        }

        public HibernateUtils(org.hibernate.SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        public org.hibernate.Session requestSession() {
            session = sessionFactory.openSession();
            return session;
        }
    }
}

