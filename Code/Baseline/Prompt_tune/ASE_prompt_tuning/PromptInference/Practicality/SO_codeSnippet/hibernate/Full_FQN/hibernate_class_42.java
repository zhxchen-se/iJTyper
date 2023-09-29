public class hibernate_class_42 {
  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(java.lang.Class);

  private final org.hibernate.SessionFactory sessionFactory = hibernate_class_42.getSessionFactory();

  protected org.hibernate.SessionFactory getSessionFactory() {
    try {
      return javax.naming.InitialContext.lookup(java.lang.String);
    } catch (java.lang.Exception e) {
      org.apache.commons.logging.Log.error(java.lang.Object,java.lang.Throwable)
      throw new java.lang.IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist() {
    org.apache.commons.logging.Log.debug(java.lang.Object)
    try {
      org.hibernate.SessionFactory.getCurrentSession()###<unknown>.persist(java.lang.String)
      org.apache.commons.logging.Log.debug(java.lang.Object)
    } catch (java.lang.RuntimeException re) {
      org.apache.commons.logging.Log.error(java.lang.Object,java.lang.Throwable)
      throw re;
    }
  }

  public void attachDirty() {
    org.apache.commons.logging.Log.debug(java.lang.Object)
    try {
      org.hibernate.SessionFactory.getCurrentSession()###<unknown>.saveOrUpdate(java.lang.String)
      org.apache.commons.logging.Log.debug(java.lang.Object)
    } catch (java.lang.RuntimeException re) {
      org.apache.commons.logging.Log.error(java.lang.Object,java.lang.Throwable)
      throw re;
    }
  }

  public void attachClean() {
    org.apache.commons.logging.Log.debug(java.lang.Object)
    try {
      org.hibernate.SessionFactory.getCurrentSession()###<unknown>.lock(java.lang.String,org.hibernate.SessionFactory,<unknown>)
      org.apache.commons.logging.Log.debug(java.lang.Object)
    } catch (java.lang.RuntimeException re) {
      org.apache.commons.logging.Log.error(java.lang.Object,java.lang.Throwable)
      throw re;
    }
  }

  public void delete() {
    org.apache.commons.logging.Log.debug(java.lang.Object)
    try {
      org.hibernate.SessionFactory.getCurrentSession()###<unknown>.delete(java.lang.String)
      org.apache.commons.logging.Log.debug(java.lang.Object)
    } catch (java.lang.RuntimeException re) {
      org.apache.commons.logging.Log.error(java.lang.Object,java.lang.Throwable)
      throw re;
    }
  }

  // public Empleados merge(Empleados detachedInstance) {
  // log.debug("merging Empleados instance");
  // try {
  // Empleados result = (Empleados) sessionFactory.getCurrentSession()
  // .merge(detachedInstance);
  // log.debug("merge successful");
  // return result;
  // } catch (RuntimeException re) {
  // log.error("merge failed", re);
  // throw re;
  // }
  // }
  // 
  // public Empleados findById(java.lang.Integer id) {
  // log.debug("getting Empleados instance with id: " + id);
  // try {
  // Empleados instance = (Empleados) sessionFactory.getCurrentSession()
  // .get("com.hibernate.Empleados", id);
  // if (instance == null) {
  // log.debug("get successful, no instance found");
  // } else {
  // log.debug("get successful, instance found");
  // }
  // return instance;
  // } catch (RuntimeException re) {
  // log.error("get failed", re);
  // throw re;
  // }
  // }
  public java.util.List findByExample() {
    org.apache.commons.logging.Log.debug(java.lang.Object)
    try {
      java.lang.Object instance = null;
      java.util.List results = org.hibernate.SessionFactory.getCurrentSession()###<unknown>.createCriteria(java.lang.String)###<unknown>.add()###<unknown>.list();
      org.apache.commons.logging.Log.debug(java.lang.Object)
      return results;
    } catch (java.lang.RuntimeException re) {
      org.apache.commons.logging.Log.error(java.lang.Object,java.lang.Throwable)
      throw re;
    }
  }
}
