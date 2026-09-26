package Tree;

public class TreeDiameter {
    static int diameter = 0;
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Returns the number of edges on the longest path between any two nodes.
    public static int diameter(Node root) {
        height(root);
        return diameter;
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Diameter of the tree: " + diameter(root));
    }
}
