public class hibernate_class_1 {
  public class HibernateUserDAO implements library.dao.UserDAO {
    private org.hibernate.SessionFactory sessionFactory;

    public HibernateUserDAO() {
      org.hibernate.cfg.AnnotationConfiguration annotConf = new org.hibernate.cfg.AnnotationConfiguration();
      org.hibernate.cfg.AnnotationConfiguration.addAnnotatedClass(java.lang.Class)
      org.hibernate.cfg.AnnotationConfiguration.configure()
      // The line below generates the exception!
      sessionFactory = org.hibernate.cfg.AnnotationConfiguration.buildSessionFactory();
    }

    public void store(library.model.User user) {
      org.hibernate.Session session = org.hibernate.SessionFactory.openSession();
      org.hibernate.Transaction tx = org.hibernate.Session.getTransaction();
      try {
        org.hibernate.Transaction.begin()
        org.hibernate.Session.saveOrUpdate(library.model.User)
        org.hibernate.Transaction.commit()
      } catch (java.lang.RuntimeException e) {
        org.hibernate.Transaction.rollback()
        throw e;
      } finally {
        org.hibernate.Session.close()
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
