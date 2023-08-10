public class hb17 {
  public static void h1() {
    org.apache.log4j.Appender clazz = null;
    java.lang.String typename = org.apache.log4j.Appender.getName();
    org.hibernate.annotations.Type type = org.hibernate.type.TypeFactory.heuristicType(java.lang.String);
    boolean serializable = (type != null) && (type instanceof org.hibernate.type.SerializableType);
  }
}
