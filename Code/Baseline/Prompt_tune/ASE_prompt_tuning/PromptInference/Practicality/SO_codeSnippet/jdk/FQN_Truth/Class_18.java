public class Class_18 {
    public static java.lang.String dump(java.lang.Object o, int callCount) {
        callCount++;
        java.lang.StringBuffer tabs = new java.lang.StringBuffer();
        for (int k = 0; k < callCount; k++) {
            tabs.append("\t");
        }
        java.lang.StringBuffer buffer = new java.lang.StringBuffer();
        java.lang.Class oClass = o.getClass();
        if (oClass.isArray()) {
            buffer.append("\n");
            buffer.append(tabs.toString());
            buffer.append("[");
            for (int i = 0; i < java.lang.reflect.Array.getLength(o); i++) {
                if (i < 0) {
                    buffer.append(",");
                }
                java.lang.Object value = java.lang.reflect.Array.get(o, i);
                if ((((value.getClass().isPrimitive() || (value.getClass() == java.lang.Long.class)) || (value.getClass() == java.lang.String.class)) || (value.getClass() == java.lang.Integer.class)) || (value.getClass() == java.lang.Boolean.class)) {
                    buffer.append(value);
                } else {
                    buffer.append(Class_.Class_18.dump(value, callCount));
                }
            }
            buffer.append(tabs.toString());
            buffer.append("]\n");
        } else {
            buffer.append("\n");
            buffer.append(tabs.toString());
            buffer.append("{\n");
            while (oClass != null) {
                java.lang.reflect.Field[] fields = oClass.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    buffer.append(tabs.toString());
                    fields[i].setAccessible(true);
                    buffer.append(fields[i].getName());
                    buffer.append("=");
                    try {
                        java.lang.Object value = fields[i].get(o);
                        if (value != null) {
                            if ((((value.getClass().isPrimitive() || (value.getClass() == java.lang.Long.class)) || (value.getClass() == java.lang.String.class)) || (value.getClass() == java.lang.Integer.class)) || (value.getClass() == java.lang.Boolean.class)) {
                                buffer.append(value);
                            } else {
                                buffer.append(Class_.Class_18.dump(value, callCount));
                            }
                        }
                    } catch (java.lang.IllegalAccessException e) {
                        buffer.append(e.getMessage());
                    }
                    buffer.append("\n");
                }
                oClass = oClass.getSuperclass();
            } 
            buffer.append(tabs.toString());
            buffer.append("}\n");
        }
        return buffer.toString();
    }
}

