package edu.wmich.CS3310.PA4.RajBasnet;

/**
 * This class contains all the information to create the node required for binary tree and implements its functions.
 * Initializes variables int item and height and Node left and right.
 */
public class Node {

	private int item, height;
	private Node left, right;

	/**
	 * Creates a constructor for Node class with parameter int item
	 * Initialize the value of item with the parameter item and value of height to be 1
	 * @param item Integer represents the item(data) in the node
	 */
	public Node(int item) {
		this.item = item;
		this.height = 1;
	}

	/**
	 * @return Returns the items of the node.
	 */
	public int getItem() {
		return item;
	}

	/**
	 * Sets the item of the given node.
	 * @param item Integer represents the item present in the node.
	 */
	public void setItem(int item) {
		this.item = item;
	}

	/**
	 * @return Returns height of the tree or tree node.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of the tree or tree node.
	 * @param height Integer represents the height of the tree or tree node.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return Returns the pointer to the left side of the given node.
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Sets the pointer towards the left side of the given node.
	 * @param left Node represents the left side of the node.
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return Returns the pointer to the right side of the given node.
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Sets the pointer towards the right side of the given node.
	 * @param right Node represents the right side of the node.
	 */
	public void setRight(Node right) {
		this.right = right;
	}
}
