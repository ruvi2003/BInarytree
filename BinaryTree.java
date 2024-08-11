package Tree;
		class TreeNode {
		    int value;
		    TreeNode leftChild, rightChild;

		    // Constructor
		    TreeNode(int value) {
		        this.value = value;
		        this.leftChild = null;
		        this.rightChild = null;
		    }
		}
		class BinaryTree {
		    TreeNode root;

		    // Constructor
		    BinaryTree() {
		        this.root = null;
		    }

		    void add(int value) {
		        root = addRecursive(root, value);
		    }

		    // Recursive method to insert a value
		    private TreeNode addRecursive(TreeNode current, int value) {
		        if (current == null) {
		            return new TreeNode(value);
		        }

		        if (value < current.value) {
		            current.leftChild = addRecursive(current.leftChild, value);
		        } else if (value > current.value) {
		            current.rightChild = addRecursive(current.rightChild, value);
		        }

		        return current;
		    }

		    
		    void remove(int value) {
		        root = removeRecursive(root, value);
		    }

		    private TreeNode removeRecursive(TreeNode current, int value) {
		        if (current == null) {
		            return null;
		        }

		        if (value < current.value) {
		            current.leftChild = removeRecursive(current.leftChild, value);
		        } else if (value > current.value) {
		            current.rightChild = removeRecursive(current.rightChild, value);
		        } else {
		            if (current.leftChild == null) {
		                return current.rightChild;
		            } else if (current.rightChild == null) {
		                return current.leftChild;
		            }

		            int smallestValue = findMinValue(current.rightChild);
		            current.value = smallestValue;
		            current.rightChild = removeRecursive(current.rightChild, smallestValue);
		        }

		        return current;
		    }

		    private int findMinValue(TreeNode root) {
		        int minValue = root.value;
		        while (root.leftChild != null) {
		            root = root.leftChild;
		            minValue = root.value;
		        }
		        return minValue;
		    }

		    void preOrderTraversal() {
		        preOrderRecursive(root);
		    }

		    private void preOrderRecursive(TreeNode node) {
		        if (node != null) {
		            System.out.print(node.value + " ");
		            preOrderRecursive(node.leftChild);
		            preOrderRecursive(node.rightChild);
		        }
		    }
		    void inOrderTraversal() {
		        inOrderRecursive(root);
		    }

		    
		    private void inOrderRecursive(TreeNode node) {
		        if (node != null) {
		            inOrderRecursive(node.leftChild);
		            System.out.print(node.value + " ");
		            inOrderRecursive(node.rightChild);
		        }
		    }

		    void postOrderTraversal() {
		        postOrderRecursive(root);
		    }

		    
		    private void postOrderRecursive(TreeNode node) {
		        if (node != null) {
		            postOrderRecursive(node.leftChild);
		            postOrderRecursive(node.rightChild);
		            System.out.print(node.value + " ");
		        }
		    }

		    
		    public static void main(String[] args) {
		        BinaryTree tree = new BinaryTree();

		        // Add values to the tree
		        tree.add(80);
		        tree.add(60);
		        tree.add(10);
		        tree.add(20);
		        tree.add(50);
		        tree.add(90);
		        tree.add(30);

		       
		        System.out.println("Pre-order traversal:");
		        tree.preOrderTraversal();
		        System.out.println();

		        System.out.println("In-order traversal:");
		        tree.inOrderTraversal();
		        System.out.println();

		        System.out.println("Post-order traversal:");
		        tree.postOrderTraversal();
		        System.out.println();

		        
		        System.out.println("Removing node with value 10:");
		        tree.remove(10);
		        System.out.println("In-order traversal after removal:");
		        tree.inOrderTraversal();
		        System.out.println();
    }
}
