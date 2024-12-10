import java.util.*;
import java.util.stream.Collectors;

public class Sorting {
    // Method to sort items by name
    public static List<String> sortByName(List<String> items) {
        return items.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    // Method to sort items based on custom criteria using a Map of popularity scores
    public static List<String> sortByCustomCriteria(List<String> items, Map<String, Integer> popularity) {
        return items.stream()
                .sorted((a, b) -> popularity.getOrDefault(b, 0) - popularity.getOrDefault(a, 0))
                .collect(Collectors.toList());
    }
}
