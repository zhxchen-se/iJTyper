public class hibernate_class_24 {
    public static class HibernateInvocationHandler implements java.lang.reflect.InvocationHandler {
        private final org.hibernate.cfg.Configuration config;

        private org.hibernate.SessionFactory realSessionFactory;

        public HibernateInvocationHandler(org.hibernate.cfg.Configuration config) {
            this.config = config;
        }

        public java.lang.Object invoke1(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
            if (false) {
                proxy.hashCode();
            }
            java.lang.System.out.println("Proxy for SessionFactory called");
            synchronized(this) {
                if (this.realSessionFactory == null) {
                    org.hibernate.SessionFactory sf = null;
                    try {
                        java.lang.System.out.println("Gonna BUILD one or die trying");
                        sf = this.config.buildSessionFactory();
                    } catch (java.lang.RuntimeException e) {
                        // System.out.println(ErrorHandle.exceptionToString(e));
                        // log.error("SessionFactoryProxy",e);
                        // closeSessionFactory(sf);
                        java.lang.System.out.println("FAILED to build");
                        sf = null;
                    }
                    // if (sf==null) throw new RetainConfigDataAccessException("SessionFactory not available");
                    this.realSessionFactory = sf;
                }
                return method.invoke(this.realSessionFactory, args);
            }
        }

        @java.lang.Override
        public java.lang.Object invoke(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
            // TODO Auto-generated method stub
            return null;
        }
    }
}

