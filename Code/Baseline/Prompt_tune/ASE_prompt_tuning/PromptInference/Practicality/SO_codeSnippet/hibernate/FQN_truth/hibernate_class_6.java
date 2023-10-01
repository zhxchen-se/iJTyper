public class hibernate_class_6 {
    public static void main(final java.lang.String[] args) throws java.net.MalformedURLException {
        java.io.File baseDir = new java.io.File("C:\\workspaces\\hobby");
        hibernate.hibernate_class_6 importer = new hibernate.hibernate_class_6();
        org.hibernate.cfg.Configuration config = importer.setupDb(baseDir);
        if (config != null) {
            importer.importContents(new java.io.File(baseDir, "people.xml"), config);
        }
    }

    private void importContents(final java.io.File file, final org.hibernate.cfg.Configuration config) throws java.net.MalformedURLException {
        org.hibernate.SessionFactory sessionFactory = config.buildSessionFactory();
        org.hibernate.Session session = sessionFactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        org.hibernate.Session dom4jSession = session.getSession(EntityMode.DOM4J);
        org.dom4j.io.SAXReader saxReader = new org.dom4j.io.SAXReader();
        try {
            org.dom4j.Document document = saxReader.read(file);
            java.util.List list = document.selectNodes("//Person");
            java.util.Iterator iter = list.iterator();
            while (iter.hasNext()) {
                java.lang.Object personObj = iter.next();
            } 
            session.flush();
            tx.commit();
            session.close();
        } catch (org.hibernate.HibernateException e) {
            e.printStackTrace();
        } catch (org.dom4j.DocumentException e) {
            e.printStackTrace();
        }
    }

    private org.hibernate.cfg.Configuration setupDb(final java.io.File baseDir) throws org.hibernate.HibernateException {
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
        cfg.addFile(new java.io.File(baseDir, "name/seller/rich/hobby/Person.hbm.xml"));
        cfg.addFile(new java.io.File(baseDir, "name/seller/rich/hobby/Hobby.hbm.xml"));
        org.hibernate.tool.hbm2ddl.SchemaExport export = new org.hibernate.tool.hbm2ddl.SchemaExport(cfg);
        export.setOutputFile("hobbyDB.txt");
        export.execute(false, true, false, false);
        return cfg;
    }
}

