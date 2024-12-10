import java.util.ArrayList;
import java.util.List;

class TreeNode {
    String name;
    List<TreeNode> children;

    TreeNode(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    void addChild(TreeNode child) {
        children.add(child);
    }
}

public class ClothingTree {
    private TreeNode root;

    public ClothingTree() {
        root = new TreeNode("Clothing");
        initializeTree();
    }

    private void initializeTree() {
        TreeNode tops = new TreeNode("Tops");
        tops.addChild(new TreeNode("Red Top"));
        tops.addChild(new TreeNode("Green Sweater"));
        tops.addChild(new TreeNode("Blue Shirt"));

        TreeNode bottoms = new TreeNode("Bottoms");
        bottoms.addChild(new TreeNode("Jeans"));
        bottoms.addChild(new TreeNode("Skirt"));
        bottoms.addChild(new TreeNode("Shorts"));

        TreeNode shoes = new TreeNode("Shoes");
        shoes.addChild(new TreeNode("Sneakers"));
        shoes.addChild(new TreeNode("Boots"));
        shoes.addChild(new TreeNode("Sandals"));

        root.addChild(tops);
        root.addChild(bottoms);
        root.addChild(shoes);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void printTree(TreeNode node, String indent) {
        System.out.println(indent + node.name);
        for (TreeNode child : node.children) {
            printTree(child, indent + "  ");
        }
    }
}
