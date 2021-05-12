package edu.wmich.CS3310.PA4.RajBasnet;

/**
 * This class represents the AVL tree needed to be created and contains all the functions needed to run required operations for AVL tree.
 * Initializes variable Node root
 */
public class AVLTree {

	private Node root;

	/**
	 * @return Returns the root node of the tree.
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * Sets the root node for the tree
	 * @param root Node represents the root node of the tree
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * This methods gives the value of the height of the tree or tree node.
	 * @param node Node represents the specified node of the tree.
	 * @return Returns the integer value of height of the tree or tree node.
	 */
	public int height(Node node) {

		//If node is null, height is 0 otherwise height is the longest path until its deepest leaf node
		if (node == null)
		{
			return 0;
		}
		return node.getHeight();
	}

	/**
	 * This methods finds the maximum of two values.
	 * @param a Integer represents the first value
	 * @param b Integer represents the second value
	 * @return Returns the integer maximum value
	 */
	public int max(int a, int b) {

		return (a > b) ? a : b;
	}

	/**
	 * This methods performs the right rotation for the specified node.
	 * @param y Node represents the tree node where rotation needs to be performed
	 * @return Returns the node rotated
	 */
	public Node rightRotate(Node y) {

		//First, left child of specified node y is stored in Node x and right child of Node x in temporary node T2
		Node x = y.getLeft();
		Node T2 = x.getRight();

		//Then, right child of x is set to be y and left child of y to be T2
		x.setRight(y);
		y.setLeft(T2);

		//Sets the height of the node y and x
		y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
		x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

		return x;
	}

	/**
	 * This methods performs the left rotation for the specified node.
	 * @param x Node represents the tree node where rotation needs to be performed
	 * @return Returns the node rotated
	 */
	public Node leftRotate(Node x) {

		//First, right child of specified node x is stored in Node y and left child of Node y in temporary node T2
		Node y = x.getRight();
		Node T2 = y.getLeft();

		//Then, left child of y is set to be x and right child of x to be T2
		y.setLeft(x);
		x.setRight(T2);

		//Sets the height of the node x and y
		x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
		y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

		return y;
	}

	/**
	 * This method gets the balance factor of the given node.
	 * @param node Node represents the specified node for which balance factor is to be found
	 * @return Returns the integer value of balance factor 
	 */
	public int getBalanceFactor(Node node) {

		//If node is null, balance factor is 0
		if (node == null) {
			return 0;
		}

		//Otherwise, balance factor is the difference between height of left subtree and right subtree of given node
		return height(node.getLeft()) - height(node.getRight());
	}

	/**
	 * This method inserts the given node containing certain data item.
	 * @param node Node represents the node to be inserted
	 * @param item Integer represents the data item stored in the node
	 * @return Returns the added node
	 */
	public Node insertNode(Node node, int item) {

		//If the node is null, add the new node
		if (node == null) {
			return (new Node(item));
		}

		//If data item is smaller than the data item of given non-empty node, recursively insert the node towards left side.
		if (item < node.getItem()) {
			node.setLeft(insertNode(node.getLeft(), item));
		}

		//Else If data item is larger than the data item of given non-empty node, recursively insert the node towards right side.
		else if (item > node.getItem()) {
			node.setRight(insertNode(node.getRight(), item));
		}

		//Else node is no added and it is returned
		else {
			return node;
		}

		//Now, the balance factor of the nodes are changed, so required rotations are needed to be performed
		//Sets the height for tree node
		node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

		//Gets the balance factor of the node
		int balanceFactor = getBalanceFactor(node);

		//If balance factor is greater than 1
		if (balanceFactor > 1) {

			//Right rotation is performed if data item to be added is smaller than left child of the specified node (whose balance factor is greater than 1)
			if (item < node.getLeft().getItem()) {
				System.out.println("Right");
				return rightRotate(node);
			} 
			//Otherwise, if data item to be added is larger than left child of the specified node, then left-right rotation is performed
			else if (item > node.getLeft().getItem()) {
				node.setLeft(leftRotate(node.getLeft()));
				System.out.println("Left-Right");
				return rightRotate(node);
			}
		}

		//If balance factor is smaller than -1
		if (balanceFactor < -1) {

			//Left rotation is performed if data item to be added is larger than right child of the specified node (whose balance factor is smaller than -1)
			if (item > node.getRight().getItem()) {
				System.out.println("Left");
				return leftRotate(node);
			} 
			//Otherwise, if data item to be added is smaller than right child of the specified node, then right-left rotation is performed
			else if (item < node.getRight().getItem()) {
				System.out.println("Right-Left");
				node.setRight(rightRotate(node.getRight()));
				return leftRotate(node);
			}
		}

		//The added node is returned
		return node;
	}

	/**
	 * Finds the node with the minimum value (data item)
	 * @param node Node represents the node whose minimum value is to be found
	 * @return Returns the node having minimum value
	 */
	public Node nodeWithMimumValue(Node node) {

		Node current = node;

		//Recursively traverse towards the last node toward the left side of tree and returns the leaf node of left side
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	/**
	 * This method deletes the node from the tree if its exists
	 * @param root Node represents the root node of the tree
	 * @param item Integer represents the item whose node is to be deleted
	 * @return Returns the deleted node
	 */
	public Node deleteNode(Node root, int item) {

		//If root is null, just return root
		if (root == null) {
			return root;
		}

		//If the item to be deleted is smaller than item of root node, recursively delete node towards left side
		if (item < root.getItem()) {
			root.setLeft(deleteNode(root.getLeft(), item));
		}

		//If the item to be deleted is larger than item of root node, recursively delete node towards right side
		else if (item > root.getItem()) {
			root.setRight(deleteNode(root.getRight(), item));
		}

		//If the item to be deleted is same as item of root node, then it is the node to be deleted
		else {

			//For node with only one child or no child  
			if ((root.getLeft() == null) || (root.getRight() == null)) {

				Node temp = null;

				//Simply replace the node with its right or left child
				if (temp == root.getLeft()) {
					temp = root.getRight();
				}
				else {
					temp = root.getLeft();
				}

				//For no child, simply delete the node 
				if (temp == null) {
					temp = root;
					root = null;
				} else  // One child case  
					root = temp;
			} else {

				//For node with two children, finds the inorder successor (smallest in the right subtree) 
				Node temp = nodeWithMimumValue(root.getRight());

				//Replace the data of node with the data of its inorder successor
				root.setItem(temp.getItem());

				//Remove the inorder successor node from its previous position 
				root.setRight(deleteNode(root.getRight(), temp.getItem()));
			}
		}

		//If the tree had only one node then return  
		if (root == null) {
			return root;
		}

		//Sets the updtaed height of the tree or tree node after deletion od node 
		root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);

		// Gets the balance factor of the given node to check if rotations are to be performed.
		int balance = getBalanceFactor(root);  

		//For imbalance of the node
		//Perform right rotation if balance factor of the node is greater than 1 and balance factor of its left child is greater than or equal to 0
		if (balance > 1 && getBalanceFactor(root.getLeft()) >= 0) {  
			System.out.println("Right");
			return rightRotate(root);  
		}

		//Perform left-right rotation if balance factor of the node is greater than 1 and balance factor of its left child is smaller than 0  
		if (balance > 1 && getBalanceFactor(root.getLeft()) < 0)  
		{  

			System.out.println("Left and Right Rotation");
			root.setLeft(leftRotate(root.getLeft()));
			System.out.println("After left rotation:");
			printTree(root, "", true);
			return rightRotate(root);  
		}  

		//Perform right rotation if balance factor of the node is smaller than -1 and balance factor of its right child is smaller than or equal to 0  
		if (balance < -1 && getBalanceFactor(root.getRight()) <= 0) {  
			System.out.println("Left");
			return leftRotate(root);  
		}

		//Perform right rotation if balance factor of the node is smaller than -1 and balance factor of its right child is greater than 0 
		if (balance < -1 && getBalanceFactor(root.getRight()) > 0)  
		{  

			System.out.println("Right and Left Rotation");
			root.setRight(rightRotate(root.getRight())); 
			return leftRotate(root);  
		}  

		return root;  
	}

	/**
	 * Prints the preorder traversal of the tree
	 * @param node Node represents the node for traversal
	 */
	public void preOrder(Node node) {

		if (node != null) {
			System.out.print(node.getItem() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	/**
	 * This method prints the AVL in certain tree-like indentation format
	 * @param currPtr Node represents the specified node for printing the tree
	 * @param indent String represents the indent added for the output to look like tree
	 * @param last Boolean represents the boolean value true or false
	 */
	public void printTree(Node currPtr, String indent, boolean last) {

		//Prints the tree until it is empty
		if (currPtr != null) {

			System.out.print(indent);

			//If true prints the root and right side of tree
			if (last) {
				System.out.print("R----");
				indent += "   ";
			}
			//If false prints the left side of the tree
			else {
				System.out.print("L----");
				indent += "|  ";
			}

			//Item to be printed
			System.out.println(currPtr.getItem());
			printTree(currPtr.getLeft(), indent, false);
			printTree(currPtr.getRight(), indent, true);
		}
	}
}
