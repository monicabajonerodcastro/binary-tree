package com.masivian.controllers;

import com.masivian.exception.BinaryTreeException;
import com.masivian.model.request.CreateBinaryTreeRequest;
import com.masivian.model.request.FindLCABinaryTreeRequest;
import com.masivian.services.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The BinaryTreeController class.
 *
 * This class represents a controller that exposes the endpoints to the creation and management of the binary tree.
 *
 * @author Monica Bajonero
 * @date 10/10/2019
 * @version 0.0.1
 */

@RestController
@RequestMapping(path = "/binaryTree")
public class BinaryTreeController {

	/** The binaryTreeService. Service to execute actions on the tree */
	@Autowired
	private BinaryTreeService binaryTreeService;

	/**
	 * Creates a binary tree with its respective nodes
	 * @param createBinaryTreeRequest		Request containing an array of indexes
	 * @return A response entity with the new binary tree
	 */
	@PostMapping(path="/create")
	public ResponseEntity<?> createBinaryTree(@RequestBody CreateBinaryTreeRequest createBinaryTreeRequest) {

		return new ResponseEntity<>(binaryTreeService.createBinaryTree(createBinaryTreeRequest), HttpStatus.OK);
	}

	/**
	 * Finds a lowest common ancestor between two nodes
	 * @param findLCABinaryTreeRequest the request with the tree and the two nodes
	 * @return A response entity with the lowest common ancestor. If the application founds some error, it returns a response
	 * 		   	entity with a BAD_REQUEST or INTERNAL_SERVER_ERROR.
	 */
	@PostMapping(path="/findLCA")
	public ResponseEntity<?> createBinaryTree(@RequestBody FindLCABinaryTreeRequest findLCABinaryTreeRequest) {

		try{
			return new ResponseEntity<>(binaryTreeService.findLowestCommonAncestor(findLCABinaryTreeRequest), HttpStatus.OK);
		}catch (BinaryTreeException bte){
			return new ResponseEntity<>(bte.getMessage(), HttpStatus.BAD_REQUEST);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
