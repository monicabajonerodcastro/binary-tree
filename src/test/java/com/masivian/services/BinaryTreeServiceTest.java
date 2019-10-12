package com.masivian.services;

import com.masivian.exception.BinaryTreeException;
import com.masivian.model.BinaryTree;
import com.masivian.model.request.CreateBinaryTreeRequest;
import com.masivian.model.request.FindLCABinaryTreeRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The BinaryTreeService test class.
 *
 * This class tests the BinaryTreeService methods
 *
 * @author Monica Bajonero
 * @date 11/10/2019
 * @version 0.0.1
 */

public class BinaryTreeServiceTest {

    /** The LOGGER constant */
    private static final Logger LOGGER = LogManager.getLogger(BinaryTreeServiceTest.class);

    /** The binaryTreeService. Service to execute actions on the tree */
    private BinaryTreeService binaryTreeService;

    /**
     * Sets the initial configuration for Tests.
     */
    @Before
    public void setUp() {
        binaryTreeService = new BinaryTreeService();

    }

    /**
     *  Tests the binary tree creation.
     */
    @Test
    public void createBinaryTreeValidateRootTest(){

        LOGGER.info("***** Testing createBinaryTreeValidateTreeTest *****");

        CreateBinaryTreeRequest createBinaryTreeRequest = new CreateBinaryTreeRequest();
        createBinaryTreeRequest.setValues(new int[]{67,39,76,74,28,85,44,29,87,83});

        BinaryTree binaryTreeTest = binaryTreeService.createBinaryTree(createBinaryTreeRequest);

        /** Validating root */
        assertNotNull(binaryTreeTest);
        assertNotNull(binaryTreeTest.getRoot());
        assertNotNull(binaryTreeTest.getRoot().getLeftChild());
        assertNotNull(binaryTreeTest.getRoot().getRightChild());
        assertEquals(67, binaryTreeTest.getRoot().getIndex());

    }

    /**
     *  Tests the lowest common ancestor for 3 examples.
     */
    @Test
    public void findLowestCommonAncestorTest() throws Exception {

        LOGGER.info("***** Testing findLowestCommonAncestorRootNullTest *****");

        CreateBinaryTreeRequest createBinaryTreeRequest = new CreateBinaryTreeRequest();
        createBinaryTreeRequest.setValues(new int[]{67,39,76,74,28,85,44,29,87,83});

        BinaryTree binaryTreeTest = binaryTreeService.createBinaryTree(createBinaryTreeRequest);

        FindLCABinaryTreeRequest findLCABinaryTreeRequestOne = new FindLCABinaryTreeRequest();
        findLCABinaryTreeRequestOne.setFirstNode(29);
        findLCABinaryTreeRequestOne.setSecondNode(44);
        findLCABinaryTreeRequestOne.setBinaryTree(binaryTreeTest);

        assertEquals(39, binaryTreeService.findLowestCommonAncestor(findLCABinaryTreeRequestOne));

        FindLCABinaryTreeRequest findLCABinaryTreeRequestTwo = new FindLCABinaryTreeRequest();
        findLCABinaryTreeRequestTwo.setFirstNode(44);
        findLCABinaryTreeRequestTwo.setSecondNode(85);
        findLCABinaryTreeRequestTwo.setBinaryTree(binaryTreeTest);

        assertEquals(67, binaryTreeService.findLowestCommonAncestor(findLCABinaryTreeRequestTwo));

        FindLCABinaryTreeRequest findLCABinaryTreeRequestThree = new FindLCABinaryTreeRequest();
        findLCABinaryTreeRequestThree.setFirstNode(83);
        findLCABinaryTreeRequestThree.setSecondNode(87);
        findLCABinaryTreeRequestThree.setBinaryTree(binaryTreeTest);

        assertEquals(85, binaryTreeService.findLowestCommonAncestor(findLCABinaryTreeRequestThree));

    }

    /**
     *  Tests the exception when the root is null.
     */
    @Test(expected = BinaryTreeException.class)
    public void findLowestCommonAncestorRootNullTest() throws Exception {

        LOGGER.info("***** Testing findLowestCommonAncestorRootNullTest *****");
        FindLCABinaryTreeRequest findLCABinaryTreeRequestOne = new FindLCABinaryTreeRequest();
        binaryTreeService.findLowestCommonAncestor(findLCABinaryTreeRequestOne);

    }

    /**
     *  Tests the exception when the root is equal to some node.
     */
    @Test(expected = BinaryTreeException.class)
    public void findLowestCommonAncestorRootEqualNodeTest() throws Exception {

        LOGGER.info("***** Testing findLowestCommonAncestorRootEqualNodeTest *****");

        CreateBinaryTreeRequest createBinaryTreeRequest = new CreateBinaryTreeRequest();
        createBinaryTreeRequest.setValues(new int[]{67,39,76,74,28,85,44,29,87,83});

        BinaryTree binaryTreeTest = binaryTreeService.createBinaryTree(createBinaryTreeRequest);

        FindLCABinaryTreeRequest findLCABinaryTreeRequest = new FindLCABinaryTreeRequest();
        findLCABinaryTreeRequest.setFirstNode(67);
        findLCABinaryTreeRequest.setSecondNode(44);
        findLCABinaryTreeRequest.setBinaryTree(binaryTreeTest);

        binaryTreeService.findLowestCommonAncestor(findLCABinaryTreeRequest);
    }

}
