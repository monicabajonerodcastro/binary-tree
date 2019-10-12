package com.masivian.services;

import com.masivian.exception.BinaryTreeException;
import com.masivian.model.BinaryTree;
import com.masivian.model.request.CreateBinaryTreeRequest;
import com.masivian.model.NodeBinaryTree;
import com.masivian.model.request.FindLCABinaryTreeRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * The BinaryTreeService class.
 *
 * This class represents a service that contains a methods associated with the binary tree operations
 *
 * @author Monica Bajonero
 * @date 10/10/2019
 * @version 0.0.1
 */

@Component
public class BinaryTreeService {

    /** The LOGGER constant */
    private static final Logger LOGGER = LogManager.getLogger(BinaryTreeService.class);

    /**
     * Creates a binary tree
     * @param createBinaryTreeRequest the request with the values of the binary tree
     */
    public BinaryTree createBinaryTree(CreateBinaryTreeRequest createBinaryTreeRequest){

        LOGGER.info("Trying to create a binary tree");
        BinaryTree binaryTree = new BinaryTree();
        for(int binaryTreeRequestValue : createBinaryTreeRequest.getValues()){
            binaryTree.addNode(binaryTreeRequestValue);
        }
        LOGGER.info("The binary tree was created with the root [{}]", binaryTree.getRoot().getIndex());
        return binaryTree;
    }

    /**
     * Finds a lowest common ancestor between two nodes
     * @param findLCABinaryTreeRequest the request with the tree and the two nodes
     * @return an index of the lowest common ancestor node
     */
    public int findLowestCommonAncestor(FindLCABinaryTreeRequest findLCABinaryTreeRequest) throws Exception {

        BinaryTree binaryTree = findLCABinaryTreeRequest.getBinaryTree();
        int firstNode = findLCABinaryTreeRequest.getFirstNode();
        int secondNode = findLCABinaryTreeRequest.getSecondNode();

        LOGGER.info("Trying to find the LCA for nodes [{}] and [{}]", firstNode, secondNode);

        if (binaryTree.getRoot() == null) {
            throw new BinaryTreeException("The root of the tree can't be null");
        }

        if (firstNode == binaryTree.getRoot().getIndex() || secondNode == binaryTree.getRoot().getIndex()) {
            throw new BinaryTreeException("The root of the tree hasn't ancestor");
        }
        return findLCA(binaryTree.getRoot(), firstNode, secondNode).getIndex();
    }

    /**
     * Finds a lowest common ancestor of two nodes inside the each node
     * @param node the node to validate
     * @param firstNode the first node to be evaluated
     * @param secondNode the second node to be evaluated
     * @return a lowest common ancestor node
     */
    private NodeBinaryTree findLCA(NodeBinaryTree node, int firstNode, int secondNode){

        LOGGER.info("Validating node [{}]", node.getIndex());
        if(firstNode < node.getIndex() && secondNode < node.getIndex()){
            return findLCA(node.getLeftChild(), firstNode, secondNode);
        }else if(firstNode > node.getIndex() && secondNode > node.getIndex()){
            return findLCA(node.getRightChild(), firstNode, secondNode);
        }
        return node;

    }

}
