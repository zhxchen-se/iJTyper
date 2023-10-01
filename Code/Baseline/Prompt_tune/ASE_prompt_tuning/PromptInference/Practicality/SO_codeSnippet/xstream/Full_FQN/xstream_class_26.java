public class xstream_class_26 {
  public class IntegerListConverter implements com.thoughtworks.xstream.converters.SingleValueConverter {
    @java.lang.Override
    public boolean canConvert(java.lang.Class clazz) {
      return java.lang.Class.isAssignableFrom(java.lang.Class);
    }

    @java.lang.Override
    public java.lang.Object fromString(java.lang.String arg0) {
      java.util.Collection<java.lang.Integer> collection = new java.util.ArrayList<java.lang.Integer>();
      java.lang.String[] integerStrings = java.lang.String.split(java.lang.String);
      for (int i = 0; i < integerStrings.length; i++) {
        java.util.Collection.add(java.lang.Object)
      }
      return collection;
    }

    @java.lang.Override
    public java.lang.String toString(java.lang.Object arg0) {
      java.util.List collection = ((java.util.List) (arg0));
      java.lang.StringBuffer sb = new java.lang.StringBuffer();
      boolean first = true;
      for (java.lang.Object object : collection) {
        if (first) {
          first = false;
        } else {
          java.lang.StringBuffer.append(char)
        }
        java.lang.StringBuffer.append(java.lang.String)
      }
      return java.lang.StringBuffer.toString();
    }
  }
}
