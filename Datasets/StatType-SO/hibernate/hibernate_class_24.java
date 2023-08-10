
//ID = 2768511
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernate_class_24 {
	public static class HibernateInvocationHandler implements InvocationHandler {
		final private Configuration config;
		private SessionFactory realSessionFactory;
		public HibernateInvocationHandler(Configuration config) {
			this.config=config;
		}

		public Object invoke1(Object proxy, Method method, Object[] args)
				throws Throwable {
			if (false) proxy.hashCode();
			System.out.println("Proxy for SessionFactory called");
			synchronized(this) {
				if (this.realSessionFactory == null){
					SessionFactory sf =null;
					try {
						System.out.println("Gonna BUILD one or die trying");

						sf=this.config.buildSessionFactory();
					} catch (RuntimeException e) {
						//	                        System.out.println(ErrorHandle.exceptionToString(e));
						//	                        log.error("SessionFactoryProxy",e);
						//	                        closeSessionFactory(sf);
						System.out.println("FAILED to build");
						sf=null;
					}
					//	                    if (sf==null) throw new RetainConfigDataAccessException("SessionFactory not available");
					this.realSessionFactory=sf;                     
				}
				return method.invoke(this.realSessionFactory, args);    
			}

		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
