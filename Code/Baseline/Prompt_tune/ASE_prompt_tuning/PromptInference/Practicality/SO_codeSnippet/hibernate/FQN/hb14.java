public class hb14 {
    public static void h1(org.hibernate.mapping.List model) {
        org.hibernate.mapping.SimpleValue iv = new org.hibernate.mapping.SimpleValue(model.getCollectionTable());
        model.setIndex(iv);
    }
}

