package com.masivian.services;

import com.masivian.model.BinaryTree;
import com.masivian.model.BinaryTreeRequest;
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
     * @param binaryTreeRequest the request with the values of the binary tree
     */
    public BinaryTree createBinaryTree(BinaryTreeRequest binaryTreeRequest){

        LOGGER.info("Trying to create a binary tree");
        BinaryTree binaryTree = new BinaryTree();
        for(int binaryTreeRequestValue : binaryTreeRequest.getValues()){
            binaryTree.addNode(binaryTreeRequestValue);
        }
        LOGGER.info("The binary tree was created with the root [{}]", binaryTree.getRoot().getIndex());
        return binaryTree;
    }
}
