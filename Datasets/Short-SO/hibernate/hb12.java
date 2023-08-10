package java.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.QueryException;
import org.hibernate.annotations.Type;
import org.hibernate.engine.Mapping;

import java.sql.Types;

public class hb12 {
    public Type getReturnType(Type columnType, Mapping mapping) throws QueryException {
        int[] sqlTypes = new int[0];
        if (sqlTypes.length!=1) throw new QueryException("multi-column type in avg()");
        return columnType;
    }
}
