package java.hibernate;

import org.hibernate.mapping.List;
import org.hibernate.mapping.SimpleValue;


public class hb14 {
    public static void h1( List model) {
        SimpleValue iv = new SimpleValue( model.getCollectionTable() );
        model.setIndex(iv);
    }


}
