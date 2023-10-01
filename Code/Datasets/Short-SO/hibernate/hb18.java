package java.hibernate;

import org.hibernate.mapping.List;
import org.hibernate.mapping.SimpleValue;


public class hb18 {
    public static void h1(){
        List model = null;
        SimpleValue iv = new SimpleValue( model.getCollectionTable() );
        model.setIndex(iv);
    }

}
