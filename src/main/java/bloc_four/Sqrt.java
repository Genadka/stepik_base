package bloc_four;

public class Sqrt {

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got" + x);
        }
        return Math.sqrt(x);
    }

    public static void main(String[] args) {
        double result = Sqrt.sqrt(4.0);
        System.out.println("Результат: " + result);
    }
}
