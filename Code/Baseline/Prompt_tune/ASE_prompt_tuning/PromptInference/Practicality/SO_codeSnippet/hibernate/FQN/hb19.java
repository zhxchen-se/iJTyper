public class hb19 {
    public static void h1() {
        java.lang.String typename = null;
        org.hibernate.annotations.Type type = ((org.hibernate.annotations.Type) (org.hibernate.type.TypeFactory.heuristicType(typename)));
        boolean serializable = (type != null) && (type instanceof org.hibernate.type.SerializableType);
    }
}

