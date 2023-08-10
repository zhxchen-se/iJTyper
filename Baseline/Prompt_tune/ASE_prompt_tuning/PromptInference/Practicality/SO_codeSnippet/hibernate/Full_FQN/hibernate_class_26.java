public class hibernate_class_26 {
  private org.hibernate.SessionFactory sessionFactory;

  public static void main(java.lang.String[] args) {
    hibernate_class_26 d = new hibernate_class_26();
    hibernate_class_26.run3()
  }

  public void run3() {
    org.hibernate.Session session = hibernate_class_26.getSession();
    org.hibernate.Session.beginTransaction()
    hibernate_class_26.createEntities(org.hibernate.Session)
    org.hibernate.Session.getTransaction()###<unknown>.commit()
    java.io.PrintStream.println(java.lang.String)
    session = hibernate_class_26.getSession();
    org.hibernate.Session.beginTransaction()
    org.hibernate.Query query = org.hibernate.Session.createQuery(java.lang.String);
    java.util.List results = org.hibernate.Query.list();
    for (int i = 0; i < java.util.List.size(); i++) {
      java.io.PrintStream.println(java.lang.String)
      hibernate_class_26.A a = java.util.List.get(int);
      java.io.PrintStream.println(java.lang.String)
      java.io.PrintStream.println(java.lang.String)
    }
    org.hibernate.Session.getTransaction()###<unknown>.commit()
  }

  public void createEntities(org.hibernate.Session session) {
    for (int i = 0; i < 2; i++) {
      hibernate_class_26.A a = new hibernate_class_26.A();
      hibernate_class_26.B b = new hibernate_class_26.B();
      hibernate_class_26$A.setB(hibernate_class_26$B)
      org.hibernate.Session.save(hibernate_class_26$A)
    }
  }

  public org.hibernate.Session getSession() {
    if (sessionFactory == null) {
      org.hibernate.cfg.AnnotationConfiguration config = new org.hibernate.cfg.AnnotationConfiguration();
      org.hibernate.cfg.AnnotationConfiguration.addAnnotatedClass(java.lang.Class)
      org.hibernate.cfg.AnnotationConfiguration.addAnnotatedClass(java.lang.Class)
      org.hibernate.cfg.AnnotationConfiguration.configure()
      <unknown>.create(boolean,boolean)
      sessionFactory = org.hibernate.cfg.AnnotationConfiguration.buildSessionFactory();
    }
    org.hibernate.Session session = org.hibernate.SessionFactory.getCurrentSession();
    return session;
  }

  public class A {
    private java.lang.Integer id;

    private hibernate_class_26.B b;

    public A() {
      java.lang.Object.java.lang.Object()
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
      java.lang.Object.java.lang.Object()
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
