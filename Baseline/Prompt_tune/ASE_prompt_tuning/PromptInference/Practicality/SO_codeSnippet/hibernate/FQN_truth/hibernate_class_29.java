public abstract class hibernate_class_29<T> {
    private java.lang.Class<T> domainClass;

    private org.hibernate.SessionFactory sf;

    public hibernate_class_29(java.lang.Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    public org.hibernate.SessionFactory getSessionFactory() {
        return sf;
    }

    public void setSessionFactory(org.hibernate.SessionFactory sf) {
        this.sf = sf;
    }

    public void delete(T object) {
        getSession().delete(object);
    }

    @java.lang.SuppressWarnings("unchecked")
    public T load(long id) {
        return ((T) (getSession().get(domainClass, id)));
    }

    public void save(T object) {
        getSession().saveOrUpdate(object);
    }

    @java.lang.SuppressWarnings("unchecked")
    public java.util.List<T> findAll() {
        org.hibernate.Criteria criteria = getSession().createCriteria(domainClass);
        java.util.List<T> r = ((java.util.List<T>) (criteria.list()));
        return r;
    }

    public int countAll() {
        org.hibernate.Criteria criteria = getSession().createCriteria(domainClass);
        criteria.setProjection(org.hibernate.criterion.Projections.rowCount());
        return ((java.lang.Integer) (criteria.uniqueResult()));
    }

    public org.hibernate.Session getSession() {
        return sf.getCurrentSession();
    }
}

