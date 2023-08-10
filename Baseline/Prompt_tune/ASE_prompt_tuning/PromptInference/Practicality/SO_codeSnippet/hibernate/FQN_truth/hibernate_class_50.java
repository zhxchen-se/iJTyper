public class hibernate_class_50 {
    private org.hibernate.SessionFactory sessionFactory;

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @java.lang.SuppressWarnings("unchecked")
    public java.util.List<javax.naming.Name> getAll() {
        org.hibernate.Session session = this.sessionFactory.getCurrentSession();
        java.util.List<javax.naming.Name> names = ((java.util.List<javax.naming.Name>) (session.createQuery("from Name").list()));
        return names;
    }

    public void save(javax.naming.Name name) {
        org.hibernate.Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(name);
        session.flush();
    }
}

