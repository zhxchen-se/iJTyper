public class hibernate_class_42 {
    private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(hibernate.hibernate_class_42.class);

    private final org.hibernate.SessionFactory sessionFactory = getSessionFactory();

    protected org.hibernate.SessionFactory getSessionFactory() {
        try {
            return ((org.hibernate.SessionFactory) (new javax.naming.InitialContext().lookup("java:/hibernate/SessionFactory")));
        } catch (java.lang.Exception e) {
            hibernate.hibernate_class_42.log.error("Could not locate SessionFactory in JNDI", e);
            throw new java.lang.IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist() {
        hibernate.hibernate_class_42.log.debug("persisting Empleados instance");
        try {
            sessionFactory.getCurrentSession().persist("aa");
            hibernate.hibernate_class_42.log.debug("persist successful");
        } catch (java.lang.RuntimeException re) {
            hibernate.hibernate_class_42.log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty() {
        hibernate.hibernate_class_42.log.debug("attaching dirty Empleados instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate("aa");
            hibernate.hibernate_class_42.log.debug("attach successful");
        } catch (java.lang.RuntimeException re) {
            hibernate.hibernate_class_42.log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean() {
        hibernate.hibernate_class_42.log.debug("attaching clean Empleados instance");
        try {
            sessionFactory.getCurrentSession().lock("aa", sessionFactory, null);
            hibernate.hibernate_class_42.log.debug("attach successful");
        } catch (java.lang.RuntimeException re) {
            hibernate.hibernate_class_42.log.error("attach failed", re);
            throw re;
        }
    }

    public void delete() {
        hibernate.hibernate_class_42.log.debug("deleting Empleados instance");
        try {
            sessionFactory.getCurrentSession().delete("aa");
            hibernate.hibernate_class_42.log.debug("delete successful");
        } catch (java.lang.RuntimeException re) {
            hibernate.hibernate_class_42.log.error("delete failed", re);
            throw re;
        }
    }

    public java.util.List findByExample() {
        hibernate.hibernate_class_42.log.debug("finding Empleados instance by example");
        try {
            java.lang.Object instance = null;
            java.util.List results = sessionFactory.getCurrentSession().createCriteria("com.hibernate.Empleados").add(org.hibernate.criterion.Example.create(instance)).list();
            hibernate.hibernate_class_42.log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (java.lang.RuntimeException re) {
            hibernate.hibernate_class_42.log.error("find by example failed", re);
            throw re;
        }
    }
}

