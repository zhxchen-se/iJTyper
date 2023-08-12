[
  {
    "maskCode": "private static final <mask><mask><mask>.Log log = LogFactory.getLog(hibernate_class_42.class);",
    "Glob_context": "//ID = 3754253 public class hibernate_class_42 { private static final <mask><mask><mask>.Log log = LogFactory.getLog(hibernate_class_42.class); private final SessionFactory sessionFactory = getSessionFactory(); protected SessionFactory getSessionFactory() { try { return (SessionFactory) new InitialContext() .lookup(String);"
  },
  {
    "maskCode": "private static final Log log = <mask><mask><mask>.LogFactory.getLog(hibernate_class_42.class);",
    "Glob_context": "//ID = 3754253 public class hibernate_class_42 { private static final Log log = <mask><mask><mask>.LogFactory.getLog(hibernate_class_42.class); private final SessionFactory sessionFactory = getSessionFactory(); protected SessionFactory getSessionFactory() { try { return (SessionFactory) new InitialContext() .lookup(String);"
  },
  {
    "maskCode": "private final <mask><mask><mask>.SessionFactory sessionFactory = getSessionFactory();",
    "Glob_context": "//ID = 3754253 public class hibernate_class_42 { private static final Log log = LogFactory.getLog(hibernate_class_42.class); private final <mask><mask><mask>.SessionFactory sessionFactory = getSessionFactory(); protected SessionFactory getSessionFactory() { try { return (SessionFactory) new InitialContext() .lookup(String); } catch (Exception e) { log.error(String, e);"
  },
  {
    "maskCode": "protected <mask><mask><mask>.SessionFactory getSessionFactory() {",
    "Glob_context": "//ID = 3754253 public class hibernate_class_42 { private static final Log log = LogFactory.getLog(hibernate_class_42.class); private final SessionFactory sessionFactory = getSessionFactory(); protected <mask><mask><mask>.SessionFactory getSessionFactory() { try { return (SessionFactory) new InitialContext() .lookup(String); } catch (Exception e) { log.error(String, e); throw new IllegalStateException( String);"
  },
  {
    "maskCode": "return (<mask><mask><mask>.SessionFactory) new InitialContext()",
    "Glob_context": "//ID = 3754253 public class hibernate_class_42 { private static final Log log = LogFactory.getLog(hibernate_class_42.class); private final SessionFactory sessionFactory = getSessionFactory(); protected SessionFactory getSessionFactory() { try { return (<mask><mask><mask>.SessionFactory) new InitialContext() .lookup(String); } catch (Exception e) { log.error(String, e); throw new IllegalStateException( String);"
  },
  {
    "maskCode": "return (SessionFactory) new <mask><mask><mask>.InitialContext()",
    "Glob_context": "//ID = 3754253 public class hibernate_class_42 { private static final Log log = LogFactory.getLog(hibernate_class_42.class); private final SessionFactory sessionFactory = getSessionFactory(); protected SessionFactory getSessionFactory() { try { return (SessionFactory) new <mask><mask><mask>.InitialContext() .lookup(String); } catch (Exception e) { log.error(String, e); throw new IllegalStateException( String);"
  },
  {
    "maskCode": "public <mask><mask><mask>.List findByExample() {",
    "Glob_context": "// } catch (RuntimeException re) { // log.error(String, re); // throw re; // } // } public <mask><mask><mask>.List findByExample() { log.debug(String); try { Object instance = null; List results = sessionFactory.getCurrentSession().createCriteria( String).add(Example.create(instance)) .list();"
  },
  {
    "maskCode": "<mask><mask><mask>.List results = sessionFactory.getCurrentSession().createCriteria(",
    "Glob_context": "// } // } public List findByExample() { log.debug(String); try { Object instance = null; <mask><mask><mask>.List results = sessionFactory.getCurrentSession().createCriteria( String).add(Example.create(instance)) .list(); log.debug(String + results.size()); return results;"
  },
  {
    "maskCode": "String).add(<mask><mask><mask>.Example.create(instance))",
    "Glob_context": "// } // } public List findByExample() { log.debug(String); try { Object instance = null; List results = sessionFactory.getCurrentSession().createCriteria( String).add(<mask><mask><mask>.Example.create(instance)) .list(); log.debug(String + results.size()); return results;"
  }
]