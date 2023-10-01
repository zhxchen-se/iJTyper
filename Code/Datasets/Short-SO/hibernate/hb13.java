package java.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Type;
import org.hibernate.type.TypeFactory;

public class hb13 {
    private Type h1(Class clazz) throws HibernateException {
        String typename = clazz.getName();
        return (Type) Hibernate.entity(clazz);
    }
}
