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
            xstream.xstream_class_44.TestObject object = xstream.xstream_class_44.getNewTestObject();
            java.io.File persistFile = new java.io.File("C:\\ABC.xml");
            java.io.FileOutputStream outStream = new java.io.FileOutputStream(persistFile);
            com.thoughtworks.xstream.XStream x = new com.thoughtworks.xstream.XStream();
            x.alias("testObject", xstream.xstream_class_44.TestObject.class);
            x.toXML(object, outStream);
            outStream.close();
        } catch (java.lang.Throwable e) {
            e.printStackTrace();
        }
    }

    public static xstream.xstream_class_44.TestObject getNewTestObject() {
        xstream.xstream_class_44.TestObject orderRecord = null;
        orderRecord.setName("OBJECT_" + xstream.xstream_class_44.COUNT);
        while ((xstream.xstream_class_44.COUNT++) < xstream.xstream_class_44.MAX_DEPTH) {
            orderRecord.setParentObject(xstream.xstream_class_44.getNewTestObject());
        } 
        return orderRecord;
    }

    public class TestObject {
        private xstream.xstream_class_44.TestObject parentObject;

        private java.lang.String name;

        /**
         *
         *
         * @return the parentObject
         */
        public xstream.xstream_class_44.TestObject getParentObject() {
            return parentObject;
        }

        /**
         *
         *
         * @param parentObject
         * 		the parentObject to set
         */
        public void setParentObject(xstream.xstream_class_44.TestObject parentObject) {
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

