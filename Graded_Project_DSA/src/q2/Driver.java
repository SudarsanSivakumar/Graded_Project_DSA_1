package q2;

public class Driver {
    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        // Modify the BST to not contain any left node
        tree.node = tree.insert(tree.node, tree.node.value);

        // Display the node values present in ascending order
        displayAscending(tree.node);
    }

    // Display node values in ascending order
    public static void displayAscending(Node node) {
        if (node == null) {
            return;
        }

        displayAscending(node.left);
        System.out.print(node.value + " ");
        displayAscending(node.right);
    }
}
