public class hibernate_class_46 {
  public static final java.lang.ThreadLocal session = new java.lang.ThreadLocal();

  private static hibernate_class_46 me;

  static {
    try {
      hibernate_class_46.me = new hibernate_class_46();
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
    }
  }

  private hibernate_class_46() throws org.hibernate.HibernateException, org.hibernate.JDBCException {
  }

  public org.hibernate.Session currentSession() throws java.lang.Exception {
    org.hibernate.Session s = java.lang.ThreadLocal.get();
    if (s != null) {
      org.hibernate.Session.setCacheMode()
    }
    if (s == null) {
      s = hibernate_class_46.openSession();
      java.lang.ThreadLocal.set(java.lang.Object)
    }
    return s;
  }

  public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
  }

  public static org.hibernate.Session openSession() {
    org.hibernate.Session session = null;
    return session;
  }
}
