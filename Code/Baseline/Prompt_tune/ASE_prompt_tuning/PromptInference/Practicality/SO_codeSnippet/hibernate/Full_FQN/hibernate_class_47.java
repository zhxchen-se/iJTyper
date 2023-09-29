public class hibernate_class_47 {
  public static boolean registerEvent() {
    org.hibernate.SessionFactory sf = HibernateUtil.getSessionFactory();
    org.hibernate.Transaction t = null;
    try {
      org.hibernate.Session s = org.hibernate.SessionFactory.openSession();
      t = org.hibernate.Session.beginTransaction();// start a new transaction

      org.hibernate.Session.persist(java.lang.String)
      org.hibernate.Transaction.commit()
      return true;
    } catch (java.lang.Exception ex) {
      java.io.PrintStream.println(java.lang.String)
      if (t != null)
        org.hibernate.Transaction.rollback()
      // rollback transaction on exception

      return false;
    }
  }
}
