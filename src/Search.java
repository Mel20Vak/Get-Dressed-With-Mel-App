import java.util.List;

public class Search {
    public static int binarySearch(List<String> items, String target) {
        int low = 0, high = items.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = target.compareTo(items.get(mid));
            if (comparison == 0) return mid;
            else if (comparison < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static int linearSearch(List<String> items, String target) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(target)) return i;
        }
        return -1;
    }
}
