package com.masivian.model;

import lombok.Data;

/**
 * The NodeBinaryTree class.
 *
 * This class represents each node of the binary tree
 *
 * @author Monica Bajonero
 * @date 10/10/2019
 * @version 0.0.1
 */

@Data
public class NodeBinaryTree {

	/** Index of the node */
	private int index;

	/** Left child of the node. This index must be lower to the parent's index */
	private NodeBinaryTree leftChild;

	/** Right child of the node. This index must be larger to the parent's index */
	private NodeBinaryTree rightChild;

	/**
	 * The NodeBinaryTree Constructor
	 * This constructor instantiates a NodeBinaryTree object with the index and its children null
	 */
	public NodeBinaryTree(int index){
		this.index = index;
		this.leftChild = null;
		this.rightChild = null;
	}

}
