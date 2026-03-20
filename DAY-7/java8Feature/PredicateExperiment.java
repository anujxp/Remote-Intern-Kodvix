import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

 class PredicateExperiment {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java", "Python", "C++", "JavaScript", "Julia");

        // Experiment: Create a predicate for names longer than 4 characters
        Predicate<String> isLongName = s -> s.length() > 4;

        // Use it with Streams (highly recommended for your Java Full Stack path)
        List<String> filteredNames = names.stream()
                                         .filter(isLongName)
                                         .collect(Collectors.toList());

        System.out.println("Long names: " + filteredNames); // [Python, JavaScript]
    }
}