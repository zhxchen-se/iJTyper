public class Class_14 {
    public static void main(java.lang.String[] args) throws java.lang.Exception {
        java.lang.String dogClassName = "com.mypackage.bean.Dog";
        java.lang.Class<?> dogClass = java.lang.Class.forName(dogClassName);

        java.lang.Object dog = dogClass.newInstance();

        java.lang.String methodName = "";

        methodName = "setName";
        java.lang.reflect.Method setNameMethod = dog.getClass().getMethod(methodName, java.lang.String.class);
        setNameMethod.invoke(dog, "Mishka");


        methodName = "getName";
        java.lang.reflect.Method getNameMethod = dog.getClass().getMethod(methodName);
        java.lang.String name = ((java.lang.String) (getNameMethod.invoke(dog)));

        methodName = "printDog";
        java.lang.Class<?>[] paramTypes = new java.lang.Class<?>[]{ java.lang.String.class, int.class };
        java.lang.reflect.Method printDogMethod = dog.getClass().getMethod(methodName, paramTypes);
        printDogMethod.invoke(dog, name, 3);

    }
}

