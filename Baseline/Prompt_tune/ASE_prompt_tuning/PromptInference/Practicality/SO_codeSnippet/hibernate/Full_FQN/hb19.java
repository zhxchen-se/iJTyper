public class hb19 {
  public static void h1() {
    java.lang.String typename = null;
    org.hibernate.annotations.Type type = org.hibernate.type.TypeFactory.heuristicType(java.lang.String);
    boolean serializable = (type != null) && (type instanceof org.hibernate.type.SerializableType);
  }
}
