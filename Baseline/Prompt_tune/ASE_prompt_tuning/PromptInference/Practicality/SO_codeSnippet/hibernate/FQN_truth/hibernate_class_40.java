public class hibernate_class_40 {
    public static void main(java.lang.String[] args) {
        org.hibernate.Session session = null;
        try {
            org.hibernate.SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            java.lang.System.out.println("selecting records");
            org.hibernate.Query q = session.getNamedQuery("getRecordsSP");
            java.lang.System.out.print("Done");
            java.util.List l = q.list();
            for (java.util.Iterator it = l.iterator(); it.hasNext();) {
                java.lang.Object[] row = ((java.lang.Object[]) (it.next()));
                java.lang.System.out.println(row.length);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}

