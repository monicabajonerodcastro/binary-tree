package com.masivian.model;

import lombok.Data;

/**
 * The BinaryTreeRequest class.
 *
 * This class represents the request to create a binary tree
 *
 * @author Monica Bajonero
 * @date 10/10/2019
 * @version 0.0.1
 */

@Data
public class BinaryTreeRequest {

    /** The index values to insert to the binary tree */
    private int[] values;
}
