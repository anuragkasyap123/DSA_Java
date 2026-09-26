package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeWidth {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Returns the maximum number of nodes present at any one level.
    public static int width(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        int maximumWidth = 0;

        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            maximumWidth = Math.max(maximumWidth, levelSize);

            for (int index = 0; index < levelSize; index++) {
                Node node = nodes.remove();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }

        return maximumWidth;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Width of the tree: " + width(root));
    }
}
