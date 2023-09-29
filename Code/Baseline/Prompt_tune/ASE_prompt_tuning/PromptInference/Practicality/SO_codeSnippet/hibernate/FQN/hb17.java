public class hb17 {
    public static void h1() {
        org.apache.log4j.Appender clazz = null;
        java.lang.String typename = clazz.getName();
        org.hibernate.annotations.Type type = ((org.hibernate.annotations.Type) (org.hibernate.type.TypeFactory.heuristicType(typename)));
        boolean serializable = (type != null) && (type instanceof org.hibernate.type.SerializableType);
    }
}

