package com.masivian.model;

import lombok.Data;

@Data
public class NodeBinaryTree {

	private int index;
	private NodeBinaryTree leftChild;
	private NodeBinaryTree rightChild;

	public NodeBinaryTree(int index){
		this.index = index;
		this.leftChild = null;
		this.rightChild = null;
	}

}
