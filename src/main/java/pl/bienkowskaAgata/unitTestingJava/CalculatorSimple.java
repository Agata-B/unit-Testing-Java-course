package pl.bienkowskaAgata.unitTestingJava;

public class CalculatorSimple {

    public static void main(String[] args) {
        testCalculator();
    }

    private static void testCalculator() {
        Calculator calculator = new Calculator();
        int result = calculator.sum(2, 3);

        if (result == 5) {
            System.out.println("Methods works.");
        } else throw new IllegalStateException ("Wrong result, methods doesn't work.");
    }
}