package com.masivian.exception;

/**
 * The BinaryTreeException class.
 *
 * This class represents a custom exception with the application.
 *
 * @author Monica Bajonero
 * @date 11/10/2019
 * @version 0.0.1
 */
public class BinaryTreeException extends Exception{

    /**
     * The BinaryTreeException Constructor
     * This constructor instantiates a BinaryTreeException object with an error message
     */
    public BinaryTreeException(String message){
        super(message);
    }

}
