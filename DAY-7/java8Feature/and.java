
import java.util.function.Predicate;

public class and {
public static void main(String[] args) {
    
    Predicate<String> startsWithV = s -> s.startsWith("V");
    Predicate<String> endsWithL = s -> s.endsWith("l");
    Predicate<String> combinedAnd = startsWithV.and(endsWithL);
    System.out.println(combinedAnd.test("Vipul"));
    Predicate<String> conbinedOr = startsWithV.or(endsWithL);
    System.out.println(conbinedOr.test("Vipul"));
    

    Predicate<String> notStartsWithV = startsWithV.negate();
System.out.println(notStartsWithV.test("Vipul")); // false

}
}
