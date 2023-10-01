public class hibernate_class_16 {
    public class Events {
        org.hibernate.Session hibernateSession;

        public void setHibernateSession(org.hibernate.Session hibernateSession) throws java.lang.Exception {
            this.hibernateSession = hibernateSession;
        }

        public void sethibernateSession(org.hibernate.Session hibernateSession) throws java.lang.Exception {
            this.hibernateSession = hibernateSession;
        }

        @java.lang.SuppressWarnings("unchecked")
        public java.lang.String execute() {
            java.util.List<java.awt.Event> events = hibernateSession.createQuery("from Event").list();
            for (java.awt.Event theEvent : events) {
            }
            return "success";
        }
    }
}

