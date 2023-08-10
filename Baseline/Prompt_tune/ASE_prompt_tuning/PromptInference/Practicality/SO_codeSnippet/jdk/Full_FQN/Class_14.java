public class Class_14 {
  public static void main(java.lang.String[] args) throws java.lang.Exception {
    java.lang.String dogClassName = "com.mypackage.bean.Dog";
    java.lang.Class<?> dogClass = java.lang.Class.forName(java.lang.String);// convert string classname to class

    java.lang.Object dog = java.lang.Class.newInstance();// invoke empty constructor

    java.lang.String methodName = "";
    // with single parameter, return void
    methodName = "setName";
    java.lang.reflect.Method setNameMethod = java.lang.Object.getClass()###java.lang.Class.getMethod(java.lang.String,java.lang.Class[]);
    java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
    // without parameters, return string
    methodName = "getName";
    java.lang.reflect.Method getNameMethod = java.lang.Object.getClass()###java.lang.Class.getMethod(java.lang.String,java.lang.Class[]);
    java.lang.String name = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);// explicit cast

    // with multiple parameters
    methodName = "printDog";
    java.lang.Class<?>[] paramTypes = new java.lang.Class<?>[]{ java.lang.String.class, int.class };
    java.lang.reflect.Method printDogMethod = java.lang.Object.getClass()###java.lang.Class.getMethod(java.lang.String,java.lang.Class[]);
    java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
  }
}
