public class hb12 {
    public org.hibernate.annotations.Type getReturnType(org.hibernate.annotations.Type columnType, org.hibernate.engine.Mapping mapping) throws org.hibernate.QueryException {
        int[] sqlTypes = new int[0];
        if (sqlTypes.length != 1) {
            throw new org.hibernate.QueryException("multi-column type in avg()");
        }
        return columnType;
    }
}

