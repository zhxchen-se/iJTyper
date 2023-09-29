public class hibernate_class_1 {
    public class HibernateUserDAO implements library.dao.UserDAO {
        private org.hibernate.SessionFactory sessionFactory;

        public HibernateUserDAO() {
            org.hibernate.cfg.AnnotationConfiguration annotConf = new org.hibernate.cfg.AnnotationConfiguration();
            annotConf.addAnnotatedClass(library.model.User.class);
            annotConf.configure();
            // The line below generates the exception!
            sessionFactory = annotConf.buildSessionFactory();
        }

        public void store(library.model.User user) {
            org.hibernate.Session session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.saveOrUpdate(user);
                tx.commit();
            } catch (java.lang.RuntimeException e) {
                tx.rollback();
                throw e;
            } finally {
                session.close();
            }
        }

        @java.lang.Override
        public library.model.User getUser(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @java.lang.Override
        public library.model.User getUserByFirstLastName(java.lang.String arg0, java.lang.String arg1) {
            // TODO Auto-generated method stub
            return null;
        }

        @java.lang.Override
        public library.model.User getUserByUsername(java.lang.String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @java.lang.Override
        public int saveUser(library.model.User arg0) {
            // TODO Auto-generated method stub
            return 0;
        }
    }
}

