public class jdk1 {
    static void h1() {
        java.util.function.IntBinaryOperator plusOperation = ( a, b) -> a + b;
        java.lang.System.out.println("Sum of 10,34 : " + plusOperation.applyAsInt(10, 34));
    }
}

