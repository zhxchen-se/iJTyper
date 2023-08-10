public class Class_18 {
  public static java.lang.String dump(java.lang.Object o, int callCount) {
    callCount++;
    java.lang.StringBuffer tabs = new java.lang.StringBuffer();
    for (int k = 0; k < callCount; k++) {
      java.lang.StringBuffer.append(java.lang.String)
    }
    java.lang.StringBuffer buffer = new java.lang.StringBuffer();
    java.lang.Class oClass = java.lang.Object.getClass();
    if (java.lang.Class.isArray()) {
      java.lang.StringBuffer.append(java.lang.String)
      java.lang.StringBuffer.append(java.lang.String)
      java.lang.StringBuffer.append(java.lang.String)
      for (int i = 0; i < java.lang.reflect.Array.getLength(java.lang.Object); i++) {
        if (i < 0)
          java.lang.StringBuffer.append(java.lang.String)

        java.lang.Object value = java.lang.reflect.Array.get(java.lang.Object,int);
        if ((((java.lang.Object.getClass()###java.lang.Class.isPrimitive() || (java.lang.Object.getClass() == java.lang.Long.class)) || (java.lang.Object.getClass() == java.lang.String.class)) || (java.lang.Object.getClass() == java.lang.Integer.class)) || (java.lang.Object.getClass() == java.lang.Boolean.class)) {
          java.lang.StringBuffer.append(java.lang.Object)
        } else {
          java.lang.StringBuffer.append(java.lang.String)
        }
      }
      java.lang.StringBuffer.append(java.lang.String)
      java.lang.StringBuffer.append(java.lang.String)
    } else {
      java.lang.StringBuffer.append(java.lang.String)
      java.lang.StringBuffer.append(java.lang.String)
      java.lang.StringBuffer.append(java.lang.String)
      while (oClass != null) {
        java.lang.reflect.Field[] fields = java.lang.Class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
          java.lang.StringBuffer.append(java.lang.String)
          java.lang.reflect.AccessibleObject.setAccessible(boolean)
          java.lang.StringBuffer.append(java.lang.String)
          java.lang.StringBuffer.append(java.lang.String)
          try {
            java.lang.Object value = java.lang.reflect.Field.get(java.lang.Object);
            if (value != null) {
              if ((((java.lang.Object.getClass()###java.lang.Class.isPrimitive() || (java.lang.Object.getClass() == java.lang.Long.class)) || (java.lang.Object.getClass() == java.lang.String.class)) || (java.lang.Object.getClass() == java.lang.Integer.class)) || (java.lang.Object.getClass() == java.lang.Boolean.class)) {
                java.lang.StringBuffer.append(java.lang.Object)
              } else {
                java.lang.StringBuffer.append(java.lang.String)
              }
            }
          } catch (java.lang.IllegalAccessException e) {
            java.lang.StringBuffer.append(java.lang.String)
          }
          java.lang.StringBuffer.append(java.lang.String)
        }
        oClass = java.lang.Class.getSuperclass();
      } 
      java.lang.StringBuffer.append(java.lang.String)
      java.lang.StringBuffer.append(java.lang.String)
    }
    return java.lang.StringBuffer.toString();
  }
}
