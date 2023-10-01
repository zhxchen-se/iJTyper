public class hibernate_class_35 {
  public static void main(java.lang.String[] args) {
    org.apache.log4j.BasicConfigurator.configure()
    org.hibernate.Session session = HibernateUtil.getSessionFactory()###<unknown>.openSession();
    org.hibernate.Transaction transaction = null;
    try {
      transaction = org.hibernate.Session.beginTransaction();
      // Label label = new Label("vijay");
      org.hibernate.Query query = org.hibernate.Session.createQuery(java.lang.String);
      java.util.List list = org.hibernate.Query.list();
      for (java.util.Iterator it = java.util.List.iterator(); java.util.Iterator.hasNext();) {
        // System.out.println(label.getId());
      }
      org.hibernate.Transaction.commit()
    } catch (org.hibernate.HibernateException e) {
      if (transaction != null) {
        org.hibernate.Transaction.rollback()
      }
      org.hibernate.HibernateException.printStackTrace()
    } finally {
      org.hibernate.Session.close()
    }
  }
}
