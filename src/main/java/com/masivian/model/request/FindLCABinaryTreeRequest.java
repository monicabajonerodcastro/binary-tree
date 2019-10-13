package com.masivian.model.request;

import com.masivian.model.BinaryTree;
import lombok.Data;

/**
 * The FindLCABinaryTreeRequest class.
 *
 * This class represents the request to find the lower common ancestor between two nodes
 *
 * @author Monica Bajonero
 * @date 11/10/2019
 * @version 0.0.1
 */

@Data
public class FindLCABinaryTreeRequest {

    /** The binary tree to be evaluated */
    private BinaryTree binaryTree;

    /** The first node to be evaluated */
    private int firstNode;

    /** The second node tree to be evaluated */
    private int secondNode;
}
