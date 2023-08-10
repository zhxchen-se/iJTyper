public class hb13 {
    private org.hibernate.annotations.Type h1(java.lang.Class clazz) throws org.hibernate.HibernateException {
        java.lang.String typename = clazz.getName();
        return ((org.hibernate.annotations.Type) (org.hibernate.Hibernate.entity(clazz)));
    }
}

