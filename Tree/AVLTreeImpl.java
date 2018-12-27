public class AVLTreeImpl {

    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    Node root;

    public int height(Node n) {
        if (n == null) {
            return 0;
        }
        return n.height;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node leftRotate(Node current) {

        Node newRootNode = current.right;
        Node T2 = newRootNode.left;

        // Perform rotation
        newRootNode.left = current;
        current.right = T2;

        //  Update heights
        current.height = max(height(current.left), height(current.right)) + 1;
        newRootNode.height = max(height(newRootNode.left), height(newRootNode.right)) + 1;

        // Return new root
        return newRootNode;
    }

    Node rightRotate(Node current) {

        Node newRootNode = current.left;
        Node T2 = newRootNode.right;

        // Perform rotation
        newRootNode.right = current;
        current.left = T2;

        // Update heights
        current.height = max(height(current.left), height(current.right)) + 1;
        newRootNode.height = max(height(newRootNode.left), height(newRootNode.right)) + 1;

        // Return new root
        return newRootNode;
    }

    int getBalance(Node n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return (new Node(key));
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        //Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTreeImpl tree = new AVLTreeImpl();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}
