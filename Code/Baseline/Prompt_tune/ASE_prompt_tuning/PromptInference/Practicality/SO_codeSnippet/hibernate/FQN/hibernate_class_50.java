public class hibernate_class_50 {
    private org.hibernate.SessionFactory sessionFactory;

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @java.lang.SuppressWarnings("unchecked")
    public java.util.List<java.util.jar.Attributes.Name> getAll() {
        org.hibernate.Session session = this.sessionFactory.getCurrentSession();
        java.util.List<java.util.jar.Attributes.Name> names = ((java.util.List<java.util.jar.Attributes.Name>) (session.createQuery("from Name").list()));
        return names;
    }

    public void save(java.util.jar.Attributes.Name name) {
        org.hibernate.Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(name);
        session.flush();
    }
}

