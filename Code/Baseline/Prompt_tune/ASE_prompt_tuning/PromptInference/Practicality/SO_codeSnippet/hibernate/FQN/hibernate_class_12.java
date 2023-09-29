public class hibernate_class_12 {
    public void main() {
        org.hibernate.Session session = null;
        try {
            org.hibernate.SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            java.lang.String id = ((java.lang.String) (javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("storeId")));
            org.hibernate.Transaction t = session.beginTransaction();
            t.commit();
        } catch (java.lang.Exception e) {
        } finally {
            session.close();
        }
    }
}

