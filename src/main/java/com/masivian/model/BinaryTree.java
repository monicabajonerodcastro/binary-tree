package com.masivian.model;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The BinaryTree class.
 *
 * This class represents a binary tree.
 *
 * @author Monica Bajonero
 * @date 10/10/2019
 * @version 0.0.1
 */
@Data
public class BinaryTree {

	/** The root node */
	private NodeBinaryTree root;

	/** The LOGGER constant */
	private static final Logger LOGGER = LogManager.getLogger(BinaryTree.class);

	/**
	 * The BinaryTree Constructor
	 * This constructor instantiates a BinaryTree object with a null root
	 */
	public BinaryTree(){
		this.root = null;
	}

	/**
	 * Adds a new node to the binary tree
	 * @param index		the index of node
	 */
	public void addNode(int index){

		LOGGER.info("Validating [{}] index", index);

		NodeBinaryTree nodeBinaryTree = new NodeBinaryTree(index);
		if(this.root == null){
			LOGGER.info("The binary tree haven't root. The root will be create with index [{}]", index);
			this.root = nodeBinaryTree;
		}else{

			NodeBinaryTree validateNodeBinaryTree = this.root;
			while(validateNodeBinaryTree != null){
				if(index < validateNodeBinaryTree.getIndex()){
					validateNodeBinaryTree = validateLeftNode(nodeBinaryTree, validateNodeBinaryTree);
				}else{
					validateNodeBinaryTree = validateRightNode(nodeBinaryTree, validateNodeBinaryTree);
				}
			}
		}
	}

	/**
	 * Validates the right side of the node
	 * @param nodeBinaryTree			the new node to add to the binary tree
	 * @param validateNodeBinaryTree	the node to validate
	 * @return The new node to validate into the loop. If the node is null, the process is finished.
	 */
	private NodeBinaryTree validateRightNode(NodeBinaryTree nodeBinaryTree, NodeBinaryTree validateNodeBinaryTree) {


		if(validateNodeBinaryTree.getRightChild() == null){
			LOGGER.info("Adding the node [{}] to the right of [{}]", nodeBinaryTree.getIndex(), validateNodeBinaryTree.getIndex());
			validateNodeBinaryTree.setRightChild(nodeBinaryTree);
			validateNodeBinaryTree = null;
		}else{
			validateNodeBinaryTree = validateNodeBinaryTree.getRightChild();
		}
		return validateNodeBinaryTree;
	}

	/**
	 * Validates the left side of the node
	 * @param nodeBinaryTree            the new node to add to the binary tree
	 * 	 * @param validateNodeBinaryTree	the node to validate
	 * @return The new node to validate into the loop. If the node is null, the process is finished.
	 */
	private NodeBinaryTree validateLeftNode(NodeBinaryTree nodeBinaryTree, NodeBinaryTree validateNodeBinaryTree) {

		if(validateNodeBinaryTree.getLeftChild() == null){
			LOGGER.info("Adding the node [{}] to the left of [{}]", nodeBinaryTree.getIndex(), validateNodeBinaryTree.getIndex());
			validateNodeBinaryTree.setLeftChild(nodeBinaryTree);
			validateNodeBinaryTree = null;
		}else{
			validateNodeBinaryTree = validateNodeBinaryTree.getLeftChild();
		}
		return validateNodeBinaryTree;
	}

}
