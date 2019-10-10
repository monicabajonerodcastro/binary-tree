package com.masivian.model;

public class BinaryTree {

	private NodeBinaryTree root;

	public BinaryTree(){
		this.root = null;
	}

	public void addNode(int index){
		NodeBinaryTree nodeBinaryTree = new NodeBinaryTree(index);

		System.out.println("Ingresando "+index);

		if(this.root == null){
			System.out.println("Raiz "+index);
			this.root = nodeBinaryTree;
		}else{

			NodeBinaryTree validateNodeBinaryTree = this.root;
			while(validateNodeBinaryTree != null){
				if(index < validateNodeBinaryTree.getIndex()){
					System.out.println("Izquierda. Padre: "+validateNodeBinaryTree.getIndex()+"Indice: "+index);
					validateNodeBinaryTree = validateLeftNode(nodeBinaryTree, validateNodeBinaryTree);
				}else{
					System.out.println("Derecha. Padre: "+validateNodeBinaryTree.getIndex()+"Indice: "+index);
					validateNodeBinaryTree = validateRightNode(nodeBinaryTree, validateNodeBinaryTree);
				}
			}
		}
	}

	private NodeBinaryTree validateRightNode(NodeBinaryTree nodeBinaryTree, NodeBinaryTree validateNodeBinaryTree) {

		if(validateNodeBinaryTree.getRightChild() == null){
			validateNodeBinaryTree.setRightChild(nodeBinaryTree);
			validateNodeBinaryTree = null;
		}else{
			validateNodeBinaryTree = validateNodeBinaryTree.getRightChild();
		}
		return validateNodeBinaryTree;
	}

	private NodeBinaryTree validateLeftNode(NodeBinaryTree nodeBinaryTree, NodeBinaryTree validateNodeBinaryTree) {

		if(validateNodeBinaryTree.getLeftChild() == null){
			validateNodeBinaryTree.setLeftChild(nodeBinaryTree);
			validateNodeBinaryTree = null;
		}else{
			validateNodeBinaryTree = validateNodeBinaryTree.getLeftChild();
		}
		return validateNodeBinaryTree;
	}

}
