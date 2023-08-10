public class Class_14 {
    public static void main(java.lang.String[] args) throws java.lang.Exception {
        java.lang.String dogClassName = "com.mypackage.bean.Dog";
        java.lang.Class<?> dogClass = java.lang.Class.forName(dogClassName);// convert string classname to class

        java.lang.Object dog = dogClass.newInstance();// invoke empty constructor

        java.lang.String methodName = "";
        // with single parameter, return void
        methodName = "setName";
        java.lang.reflect.Method setNameMethod = dog.getClass().getMethod(methodName, java.lang.String.class);
        setNameMethod.invoke(dog, "Mishka");// pass arg

        // without parameters, return string
        methodName = "getName";
        java.lang.reflect.Method getNameMethod = dog.getClass().getMethod(methodName);
        java.lang.String name = ((java.lang.String) (getNameMethod.invoke(dog)));// explicit cast

        // with multiple parameters
        methodName = "printDog";
        java.lang.Class<?>[] paramTypes = new java.lang.Class<?>[]{ java.lang.String.class, int.class };
        java.lang.reflect.Method printDogMethod = dog.getClass().getMethod(methodName, paramTypes);
        printDogMethod.invoke(dog, name, 3);// pass args

    }
}

