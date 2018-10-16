public class BinaryTree {

    static class TreeNode {
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }

        public void insert(int value) {
            if (value == data) {
                return;
            }

            if (value < data) {
                if (leftChild == null) {
                    leftChild = new TreeNode(value);
                } else {
                    leftChild.insert(value);
                }
            } else {
                if (rightChild == null) {
                    rightChild = new TreeNode(value);
                } else {
                    rightChild.insert(value);
                }
            }
        }

        public void traverseInorder() {
            if (leftChild != null) {
                leftChild.traverseInorder();
            }
            System.out.print(data + " ,");
            if (rightChild != null) {
                rightChild.traverseInorder();
            }
        }

        public TreeNode get(int value) {
            if (data == value) {
                return this;
            }

            if (value < data) {
                if (leftChild != null) {
                    return leftChild.get(value);
                }
            } else {
                if (rightChild != null) {
                    return rightChild.get(value);
                }
            }
            return null;
        }

        public int min() {
            if (leftChild == null) {
                return this.data;
            } else {
                return leftChild.min();
            }
        }

        public int max() {
            if (rightChild == null) {
                return this.data;
            } else {
                return rightChild.max();
            }
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }

    static class Tree {
        private TreeNode root;

        public void insert(int value) {
            if (root == null) {
                root = new TreeNode(value);
            } else {
                root.insert(value);
            }
        }

        public void traverseInorder() {
            if (root != null) {
                root.traverseInorder();
            }
        }

        public TreeNode get(int value) {
            if (root != null) {
                return root.get(value);
            }
            return null;
        }

        public int min() {
            if (root == null) {
                return Integer.MIN_VALUE;
            } else {
                return root.min();
            }
        }

        public int max() {
            if (root == null) {
                return Integer.MAX_VALUE;
            } else {
                return root.max();
            }
        }

        public void delete(int value) {
            root = delete(root, value);
        }

        private TreeNode delete(TreeNode subTreeRoot, int value) {
            if (subTreeRoot == null) {
                return subTreeRoot;
            }

            if (value < subTreeRoot.getData()) {
                subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
            } else if (value > subTreeRoot.getData()) {
                subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
            } else {

                //Handle condition in which node is having 0 or 1 leaf
                if (subTreeRoot.getLeftChild() == null) {
                    return subTreeRoot.getRightChild();
                } else if (subTreeRoot.getRightChild() == null) {
                    return subTreeRoot.getLeftChild();
                }

                //Case 3: Node to delete is having 2 children

                //Replace the value in the subTreeRoot node with the smallest value
                //from the right subTree
                subTreeRoot.setData(subTreeRoot.getRightChild().min());

                //Delete the node that has the smallest value in the right sub tree
                subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
            }

            return subTreeRoot;
        }
    }

    /*
     *  Types of Traversal
     *  level -> visit nodes on each level
     *  Pre-order -> visit the root nodes of every subtree at first
     *  Post-order -> visit the root node of every subtree at last
     *  In-order -> visit left child, then root, then right child
     */
    public static void main(String[] args) {
        Tree intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        /*
         *                        25
         *                      /    \
         *                     20      27
         *                    / \     /   \
         *                   15  22   26   30
         *                                 / \
         *                                29  32
         */

        intTree.traverseInorder();
        System.out.println();
        System.out.println(intTree.min());
        System.out.println(intTree.max());
        System.out.println(intTree.get(29).data);
        intTree.delete(27);
        intTree.traverseInorder();
        System.out.println();
    }
}
