public class hibernate_class_40 {
    public static void main(java.lang.String[] args) {
        org.hibernate.Session session = null;
        // String query = "select example.id, example.data from Example example";
        try {
            org.hibernate.SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            java.lang.System.out.println("selecting records");
            org.hibernate.Query q = session.getNamedQuery("getRecordsSP");
            // Query q =  session.createSQLQuery("call getRecords","",Example.class);
            java.lang.System.out.print("Done");
            java.util.List l = q.list();
            for (java.util.Iterator it = l.iterator(); it.hasNext();) {
                java.lang.Object[] row = ((java.lang.Object[]) (it.next()));
                java.lang.System.out.println(row.length);
                // System.out.println(row[0]);
                // System.out.println("ID " + row[0]);
                // System.out.println("Data "+ row[1]);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}

