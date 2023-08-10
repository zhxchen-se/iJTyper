public class hibernate_class_24 {
  public static class HibernateInvocationHandler implements java.lang.reflect.InvocationHandler {
    private final org.hibernate.cfg.Configuration config;

    private org.hibernate.SessionFactory realSessionFactory;

    public HibernateInvocationHandler(org.hibernate.cfg.Configuration config) {
      this.config = config;
    }

    public java.lang.Object invoke1(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
      if (false)
        java.lang.Object.hashCode()

      java.io.PrintStream.println(java.lang.String)
      synchronized(this) {
        if (this.realSessionFactory == null) {
          org.hibernate.SessionFactory sf = null;
          try {
            java.io.PrintStream.println(java.lang.String)
            sf = org.hibernate.cfg.Configuration.buildSessionFactory();
          } catch (java.lang.RuntimeException e) {
            java.io.PrintStream.println(java.lang.String)
            sf = null;
          }
          // if (sf==null) throw new RetainConfigDataAccessException("SessionFactory not available");
          this.realSessionFactory = sf;
        }
        return java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
      }
    }

    @java.lang.Override
    public java.lang.Object invoke(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
      // TODO Auto-generated method stub
      return null;
    }
  }
}
