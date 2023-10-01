public class hibernate_class_26 {
    private org.hibernate.SessionFactory sessionFactory;

    public static void main(java.lang.String[] args) {
        hibernate_class_26 d = new hibernate_class_26();
        d.run3();
    }

    public void run3() {
        org.hibernate.Session session = getSession();
        session.beginTransaction();
        createEntities(session);
        session.getTransaction().commit();
        java.lang.System.out.println("NOW WITH A NEW TRANSACTION");
        session = getSession();
        session.beginTransaction();
        org.hibernate.Query query = session.createQuery("from A");
        java.util.List results = query.list();
        for (int i = 0; i < results.size(); i++) {
            java.lang.System.out.println(("Row " + i) + " was:");
            hibernate_class_26.A a = ((hibernate_class_26.A) (results.get(i)));
            java.lang.System.out.println("Result " + i);
            java.lang.System.out.println(a.toString());
        }
        session.getTransaction().commit();
    }

    public void createEntities(org.hibernate.Session session) {
        for (int i = 0; i < 2; i++) {
            hibernate_class_26.A a = new hibernate_class_26.A();
            hibernate_class_26.B b = new hibernate_class_26.B();
            a.setB(b);
            session.save(a);
        }
    }

    public org.hibernate.Session getSession() {
        if (sessionFactory == null) {
            org.hibernate.cfg.AnnotationConfiguration config = new org.hibernate.cfg.AnnotationConfiguration();
            config.addAnnotatedClass(hibernate_class_26.A.class);
            config.addAnnotatedClass(hibernate_class_26.B.class);
            config.configure();
            new org.hibernate.tool.hbm2ddl.SchemaExport(config).create(true, true);
            sessionFactory = config.buildSessionFactory();
        }
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        return session;
    }

    public class A {
        private java.lang.Integer id;

        private hibernate_class_26.B b;

        public A() {
            super();
        }

        @javax.persistence.Id
        @javax.persistence.GeneratedValue
        public java.lang.Integer getId() {
            return id;
        }

        public void setId(java.lang.Integer id) {
            this.id = id;
        }

        @javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
        @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.JOIN)
        public hibernate_class_26.B getB() {
            return b;
        }

        public void setB(hibernate_class_26.B b) {
            this.b = b;
        }
    }

    @javax.persistence.Entity
    public class B {
        private java.lang.Integer id;

        public B() {
            super();
        }

        @javax.persistence.Id
        @javax.persistence.GeneratedValue
        public java.lang.Integer getId() {
            return id;
        }

        public void setId(java.lang.Integer id) {
            this.id = id;
        }
    }
}

