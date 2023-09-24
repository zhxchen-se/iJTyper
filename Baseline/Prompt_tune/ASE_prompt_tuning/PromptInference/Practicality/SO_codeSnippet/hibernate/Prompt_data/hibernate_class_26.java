[
  {
    "maskCode": "private <mask><mask><mask>.SessionFactory sessionFactory;",
    "Glob_context": "//ID = 2931936 public class hibernate_class_26 { private <mask><mask><mask>.SessionFactory sessionFactory; public static void main(String[] args){ hibernate_class_26 d = new hibernate_class_26(); d.run3();"
  },
  {
    "maskCode": "<mask><mask><mask>.Session session = getSession();",
    "Glob_context": "public static void main(String[] args){ hibernate_class_26 d = new hibernate_class_26(); d.run3(); } public void run3(){ <mask><mask><mask>.Session session = getSession(); session.beginTransaction(); createEntities(session);"
  },
  {
    "maskCode": "<mask><mask><mask>.Query query = session.createQuery(String);",
    "Glob_context": "session = getSession(); session.beginTransaction(); <mask><mask><mask>.Query query = session.createQuery(String); java.util.List results = query.list(); for (int i=0; i<results.size(); i++){ System.out.println(String+i+String);"
  },
  {
    "maskCode": "<mask><mask><mask>.List results = query.list();",
    "Glob_context": "session.beginTransaction(); org.hibernate.Query query = session.createQuery(String); <mask><mask><mask>.List results = query.list(); for (int i=0; i<results.size(); i++){ System.out.println(String+i+String); A a = (A)results.get(i);"
  },
  {
    "maskCode": "public void createEntities(<mask><mask><mask>.Session session){",
    "Glob_context": "System.out.println(a.toString()); } session.getTransaction().commit(); } public void createEntities(<mask><mask><mask>.Session session){ for (int i=0; i<2; i++){ A a = new A(); B b = new B(); a.setB(b);"
  },
  {
    "maskCode": "public <mask><mask><mask>.Session getSession(){",
    "Glob_context": "a.setB(b); session.save(a); } } public <mask><mask><mask>.Session getSession(){ if (sessionFactory == null){ org.hibernate.cfg.AnnotationConfiguration config = new org.hibernate.cfg.AnnotationConfiguration(); config.addAnnotatedClass(A.class); config.addAnnotatedClass(B.class);"
  },
  {
    "maskCode": "<mask><mask><mask>.AnnotationConfiguration config = new AnnotationConfiguration();",
    "Glob_context": "a.setB(b); session.save(a); } } public org.hibernate.Session getSession(){ if (sessionFactory == null){ <mask><mask><mask>.AnnotationConfiguration config = new org.hibernate.cfg.AnnotationConfiguration(); config.addAnnotatedClass(A.class); config.addAnnotatedClass(B.class);"
  },
  {
    "maskCode": "AnnotationConfiguration config = new <mask><mask><mask>.AnnotationConfiguration();",
    "Glob_context": "a.setB(b); session.save(a); } } public org.hibernate.Session getSession(){ if (sessionFactory == null){ org.hibernate.cfg.AnnotationConfiguration config = new <mask><mask><mask>.AnnotationConfiguration(); config.addAnnotatedClass(A.class); config.addAnnotatedClass(B.class);"
  },
  {
    "maskCode": "new <mask><mask><mask>.SchemaExport(config).create(true,true);",
    "Glob_context": "config.addAnnotatedClass(B.class); config.configure(); new <mask><mask><mask>.SchemaExport(config).create(true,true); sessionFactory = config.buildSessionFactory(); } org.hibernate.Session session = sessionFactory.getCurrentSession();"
  },
  {
    "maskCode": "<mask><mask><mask>.Session session = sessionFactory.getCurrentSession();",
    "Glob_context": "new org.hibernate.tool.hbm2ddl.SchemaExport(config).create(true,true); sessionFactory = config.buildSessionFactory(); } <mask><mask><mask>.Session session = sessionFactory.getCurrentSession(); return session; } public class A { private Integer id;"
  },
  {
    "maskCode": "@<mask><mask><mask>.Id",
    "Glob_context": "private B b; public A() { super(); } @<mask><mask><mask>.Id @javax.persistence.GeneratedValue public Integer getId() { return id; } public void setId(Integer id) { this.id = id; } @javax.persistence.OneToOne (cascade=CascadeType.ALL) @org.hibernate.annotations.Fetch(FetchMode.JOIN) public B getB() { return b;"
  },
  {
    "maskCode": "@<mask><mask><mask>.GeneratedValue",
    "Glob_context": "private B b; public A() { super(); } @javax.persistence.Id @<mask><mask><mask>.GeneratedValue public Integer getId() { return id; } public void setId(Integer id) { this.id = id; } @javax.persistence.OneToOne (cascade=CascadeType.ALL) @org.hibernate.annotations.Fetch(FetchMode.JOIN) public B getB() { return b;"
  },
  {
    "maskCode": "@<mask><mask><mask>.OneToOne (cascade=CascadeType.ALL)",
    "Glob_context": "} @javax.persistence.Id @javax.persistence.GeneratedValue public Integer getId() { return id; } public void setId(Integer id) { this.id = id; } @<mask><mask><mask>.OneToOne (cascade=CascadeType.ALL) @org.hibernate.annotations.Fetch(FetchMode.JOIN) public B getB() { return b; } public void setB(B b) { this.b = b; } } @org.hibernate.annotations.Entity public class B { private Integer id;"
  },
  {
    "maskCode": "@<mask><mask><mask>.Fetch(FetchMode.JOIN)",
    "Glob_context": "} @javax.persistence.Id @javax.persistence.GeneratedValue public Integer getId() { return id; } public void setId(Integer id) { this.id = id; } @javax.persistence.OneToOne (cascade=CascadeType.ALL) @<mask><mask><mask>.Fetch(FetchMode.JOIN) public B getB() { return b; } public void setB(B b) { this.b = b; } } @org.hibernate.annotations.Entity public class B { private Integer id;"
  },
  {
    "maskCode": "@<mask><mask><mask>.Entity",
    "Glob_context": "} @javax.persistence.OneToOne (cascade=CascadeType.ALL) @org.hibernate.annotations.Fetch(FetchMode.JOIN) public B getB() { return b; } public void setB(B b) { this.b = b; } } @<mask><mask><mask>.Entity public class B { private Integer id; public B() { super(); } @javax.persistence.Id @javax.persistence.GeneratedValue public Integer getId() { return id;"
  },
  {
    "maskCode": "@<mask><mask><mask>.Id",
    "Glob_context": "private B b; public A() { super(); } @<mask><mask><mask>.Id @javax.persistence.GeneratedValue public Integer getId() { return id; } public void setId(Integer id) { this.id = id; } @javax.persistence.OneToOne (cascade=CascadeType.ALL) @org.hibernate.annotations.Fetch(FetchMode.JOIN) public B getB() { return b;"
  },
  {
    "maskCode": "@<mask><mask><mask>.GeneratedValue",
    "Glob_context": "private B b; public A() { super(); } @javax.persistence.Id @<mask><mask><mask>.GeneratedValue public Integer getId() { return id; } public void setId(Integer id) { this.id = id; } @javax.persistence.OneToOne (cascade=CascadeType.ALL) @org.hibernate.annotations.Fetch(FetchMode.JOIN) public B getB() { return b;"
  }
]