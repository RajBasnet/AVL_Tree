package edu.wmich.CS3310.PA4.RajBasnet;

/**
 * This is the main class which contains all the information to set up the AVL tree data structure.
 * @author Raj
 */
public class Main {

	/**
	 * This is the main method which contains all the functions and attributes required to construct AVL tree
	 * @param args
	 */
	public static void main(String[] args) {

		//Create a new tree object using AVLTree class to create AVL tree data structure
		AVLTree tree = new AVLTree();

		//Construct an initial tree according to given elements using insert node function of the tree

		tree.setRoot(tree.insertNode(tree.getRoot(), 32));
		tree.setRoot(tree.insertNode(tree.getRoot(), 20));
		tree.setRoot(tree.insertNode(tree.getRoot(), 39));
		tree.setRoot(tree.insertNode(tree.getRoot(), 7));
		tree.setRoot(tree.insertNode(tree.getRoot(), 28));
		tree.setRoot(tree.insertNode(tree.getRoot(), 50));
		tree.setRoot(tree.insertNode(tree.getRoot(), 22));

		//Prints the initial tree
		System.out.println("Initial Tree: \n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();


		//Adding and removing items using insert node and delete node function of AVL tree
		//Performs these functions such that all four cases of rotation changes as well as no change can be realized

		/* After adding 21, balance factor for node (28) becomes 2 > 1, and 21 < left child of 28 (i.e. 22), so right rotation is performed.
		 * For this, left child of 28 (i.e. 22) is set to replace 28 and 28 becomes the right child of 22
		 * After this rotation, balance factor of all nodes are balanced (-1, 0 or 1)
		 */
		tree.setRoot(tree.insertNode(tree.getRoot(), 21));
		System.out.println("\nAfter adding 21, balance factor changes. \nSo, right rotation is performed.\n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();

		/* After adding 40, balance factor for node (39) becomes -2 < -1, and 40 < right child of 39 (i.e. 50), so right-left rotation is performed.
		 * For this, first right rotation is done as 50 is replaced by node (40) making 50 right child of 40
		 * Then, left rotation for node (39) is done as 39 is replaced by node (40) making 39 left child of 40
		 * After this rotation, balance factor of all nodes are balanced (-1, 0 or 1)		  
		 */
		tree.setRoot(tree.insertNode(tree.getRoot(), 40));
		System.out.println("\nAfter adding 40, balance factor changes. \nSo, right-left rotation is performed.\n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();

		/* After adding 25, balance factor for node (20) becomes -2 < -1, and 25 > right child of 20 (i.e. 22), so left rotation is performed.
		 * For this, 22 replace node (20) making 20 left child of 22 and also by making 21 (which was left child of 22) to be right child of 20
		 * After this rotation, balance factor of all nodes are balanced (-1, 0 or 1)
		 */
		tree.setRoot(tree.insertNode(tree.getRoot(), 25));
		System.out.println("\nAfter adding 25, balance factor changes. \nSo, left rotation is performed.\n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();

		//When adding 30, balance factor for all nodes remains balanced (-1, 0, 1), so no rotation required
		tree.setRoot(tree.insertNode(tree.getRoot(), 30));
		System.out.println("\nAfter adding 30, balance factor is balanced. \nSo, no rotation is performed.\n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();

		//When deleting 7, balance factor for all nodes remains balanced (-1, 0, 1), so no rotation required
		tree.setRoot(tree.deleteNode(tree.getRoot(), 7)); 
		System.out.println("\nAfter deletion of 7, balance factor is balanced. \nSo, no rotation is performed.\n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();

		//When deleting 28, balance factor for all nodes remains balanced (-1, 0, 1), so no rotation required
		tree.setRoot(tree.deleteNode(tree.getRoot(), 28)); 
		System.out.println("\nAfter deletion of 28, balance factor is balanced. \nSo, no rotation is performed.\n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();

		//When deleting 22, balance factor for all nodes remains balanced (-1, 0, 1), so no rotation required
		tree.setRoot(tree.deleteNode(tree.getRoot(), 22)); 
		System.out.println("\nAfter deletion of 22, balance factor is balanced. \nSo, no rotation is performed.\n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();

		/* After adding 30, balance factor for node (25) becomes 2 > 1, and balance factor of its left child (20) is -1 < 0, so left-right rotations is performed
		 * For this, first left rotation is done as 20 is replaced by node (21) making 20 left child of 21
		 * Then, right rotation for node (25) is done as 25 is replaced by node (21) making 25 right child of 21
		 * After this rotation, balance factor of all nodes are balanced (-1, 0 or 1)		  
		 */
		tree.setRoot(tree.deleteNode(tree.getRoot(), 30)); 
		System.out.println("\nAfter deletion of 30, balance factor changes. \nSo, left-right rotation is performed.\n");
		tree.printTree(tree.getRoot(), "", true);
		System.out.println();

		//Final tree is printed
		System.out.println("Final Tree: ");
		tree.printTree(tree.getRoot(), "", true);
		//Preorder traversal of final AVL tree
		System.out.println("\nPreorder Traversal of final AVL tree");
		tree.preOrder(tree.getRoot());
		System.out.println();
		System.out.println("Node with minimum value: " + tree.nodeWithMimumValue(tree.getRoot()).getItem()); //Tree node with minimum value
	}

}
