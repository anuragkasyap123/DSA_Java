package Tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePreorderInorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            throw new IllegalArgumentException("Traversals must be non-null and have equal lengths");
        }

        Map<Integer, Integer> inorderIndexes = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            if (inorderIndexes.put(inorder[index], index) != null) {
                throw new IllegalArgumentException("Traversal values must be unique");
            }
        }

        int[] preorderIndex = {0};
        Node root = buildTree(preorder, preorderIndex, 0, inorder.length - 1, inorderIndexes);
        if (preorderIndex[0] != preorder.length) {
            throw new IllegalArgumentException("Traversals are inconsistent");
        }
        return root;
    }

    private static Node buildTree(int[] preorder, int[] preorderIndex, int inorderStart, int inorderEnd,
            Map<Integer, Integer> inorderIndexes) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        if (preorderIndex[0] >= preorder.length) {
            throw new IllegalArgumentException("Traversals are inconsistent");
        }

        int value = preorder[preorderIndex[0]++];
        Integer rootInorderIndex = inorderIndexes.get(value);
        if (rootInorderIndex == null || rootInorderIndex < inorderStart || rootInorderIndex > inorderEnd) {
            throw new IllegalArgumentException("Traversals are inconsistent");
        }

        Node root = new Node(value);
        root.left = buildTree(preorder, preorderIndex, inorderStart, rootInorderIndex - 1, inorderIndexes);
        root.right = buildTree(preorder, preorderIndex, rootInorderIndex + 1, inorderEnd, inorderIndexes);
        return root;
    }

    private static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Node root = buildTree(preorder, inorder);
        System.out.print("Inorder of constructed tree: ");
        printInorder(root);
        System.out.println();
    }
}