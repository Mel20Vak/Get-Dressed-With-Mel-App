import java.util.*;

public class ClothingGraph {
    private Map<String, List<String>> adjList;

    public ClothingGraph() {
        adjList = new HashMap<>();
        initializeGraph();
    }

    private void initializeGraph() {
        addEdge("Red Top", "Jeans");
        addEdge("Green Sweater", "Skirt");
        addEdge("Blue Shirt", "Shorts");
        addEdge("Sneakers", "Jeans");
        addEdge("Boots", "Skirt");
        addEdge("Sandals", "Shorts");
    }

    public void addEdge(String item1, String item2) {
        adjList.computeIfAbsent(item1, k -> new ArrayList<>()).add(item2);
        adjList.computeIfAbsent(item2, k -> new ArrayList<>()).add(item1);
    }

    public List<String> getRecommendations(String item) {
        return adjList.getOrDefault(item, Collections.emptyList());
    }
}
