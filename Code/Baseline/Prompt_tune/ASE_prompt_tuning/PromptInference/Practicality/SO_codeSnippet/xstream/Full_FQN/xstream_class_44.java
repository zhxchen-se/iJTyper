public class xstream_class_44 {
  public static int COUNT = 0;

  public static int MAX_DEPTH = 800;

  /**
   *
   *
   * @param args
   * 		
   * @throws FileNotFoundException
   * 		
   */
  public static void main(java.lang.String[] args) {
    try {
      xstream_class_44.TestObject object = xstream_class_44.getNewTestObject();
      java.io.File persistFile = new java.io.File("C:\\ABC.xml");
      java.io.FileOutputStream outStream = new java.io.FileOutputStream(persistFile);
      com.thoughtworks.xstream.XStream x = new com.thoughtworks.xstream.XStream();
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.toXML(xstream_class_44$TestObject,java.io.FileOutputStream)
      java.io.FileOutputStream.close()
    } catch (java.lang.Throwable e) {
      java.lang.Throwable.printStackTrace()
    }
  }

  public static xstream_class_44.TestObject getNewTestObject() {
    xstream_class_44.TestObject orderRecord = null;
    xstream_class_44$TestObject.setName(java.lang.String)
    while ((xstream_class_44.COUNT++) < xstream_class_44.MAX_DEPTH) {
      xstream_class_44$TestObject.setParentObject(xstream_class_44$TestObject)
    } 
    return orderRecord;
  }

  public class TestObject {
    private xstream_class_44.TestObject parentObject;

    private java.lang.String name;

    /**
     *
     *
     * @return the parentObject
     */
    public xstream_class_44.TestObject getParentObject() {
      return parentObject;
    }

    /**
     *
     *
     * @param parentObject
     * 		the parentObject to set
     */
    public void setParentObject(xstream_class_44.TestObject parentObject) {
      this.parentObject = parentObject;
    }

    /**
     *
     *
     * @return the name
     */
    public java.lang.String getName() {
      return name;
    }

    /**
     *
     *
     * @param name
     * 		the name to set
     */
    public void setName(java.lang.String name) {
      this.name = name;
    }
  }
}
