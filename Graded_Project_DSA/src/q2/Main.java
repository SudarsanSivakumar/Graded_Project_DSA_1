package q2;

public class Main {
    Node node;

    // Constructor
    public Main() {
        node = null;
    }

    // Insert node into BST
    public Node insert(Node node, int value) {
        // Base case
        if (node == null) {
            node = new Node(value);
            return node;
        }

        // Insert node to the right
        node.right = insert(node.right, value);

        // Skew the tree to the right
        node = skew(node);

        // Skew the right subtree's right subtree to the right
        node.right = skew(node.right);

        // Skew the right subtree's left subtree to the right
        if (node.right != null) {
            node.right.left = skew(node.right.left);
        }

        // Split the tree
        node = split(node);

        return node;
    }

    // Skew operation
    public Node skew(Node node) {
        if (node == null) {
            return null;
        }

        // Swap left and right subtrees
        if (node.left != null && node.left.value > node.value) {
            Node left = node.left;
            node.left = left.right;
            left.right = node;
            node = left;
        }

        return node;
    }

    // Split operation
    public Node split(Node node) {
        if (node == null) {
            return null;
        }

        // Swap left and right subtrees
        if (node.right != null && node.right.right != null && node.value > node.right.right.value) {
            Node right = node.right;
            node.right = right.left;
            right.left = node;
            node = right;
            node.right = split(node.right);
        }

        return node;
    }
}
