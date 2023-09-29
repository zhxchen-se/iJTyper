public class hibernate_class_40 {
  public static void main(java.lang.String[] args) {
    org.hibernate.Session session = null;
    // String query = "select example.id, example.data from Example example";
    try {
      org.hibernate.SessionFactory sessionFactory = org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
      session = org.hibernate.SessionFactory.openSession();
      java.io.PrintStream.println(java.lang.String)
      org.hibernate.Query q = org.hibernate.Session.getNamedQuery(java.lang.String);
      java.io.PrintStream.print(java.lang.String)
      java.util.List l = org.hibernate.Query.list();
      for (java.util.Iterator it = java.util.List.iterator(); java.util.Iterator.hasNext();) {
        java.lang.Object[] row = java.util.Iterator.next();
        java.io.PrintStream.println(int)
        // System.out.println(row[0]);
        // System.out.println("ID " + row[0]);
        // System.out.println("Data "+ row[1]);
      }
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
    } finally {
      org.hibernate.Session.flush()
      org.hibernate.Session.close()
    }
  }
}
