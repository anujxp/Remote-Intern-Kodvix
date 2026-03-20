import java.util.function.Predicate;

class Main {
    public static void main(String[] args) {
        // Defining a predicate using Lambda expression
        Predicate<Integer> salaryGreaterThan100k = x -> x > 100000;

        // Using .test() to evaluate the condition
        System.out.println(salaryGreaterThan100k.test(150000)); // Output: true
        System.out.println(salaryGreaterThan100k.test(50000));  // Output: false

        Predicate<String> startWithv = s->s.toLowerCase().startsWith("v");
        System.out.println(startWithv.test("anuj"));
        System.out.println(startWithv.test("vipul"));
    }
}