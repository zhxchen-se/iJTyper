package java.hibernate;

import org.hibernate.annotations.Type;
import org.hibernate.type.SerializableType;
import org.hibernate.type.TypeFactory;

public class hb19 {
    public static void h1(){
        String typename=null;
        Type type = (Type) TypeFactory.heuristicType(typename);
        boolean serializable = type!=null && type instanceof SerializableType;
    }

}



