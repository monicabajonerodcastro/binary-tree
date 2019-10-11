package com.masivian.controllers;

import com.masivian.model.BinaryTreeRequest;
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
	 * @param binaryTreeRequest		Request containing an array of indexes
	 * @return A response entity with the new binary tree
	 */
	@PostMapping(path="/create")
	public ResponseEntity<?> createBinaryTree(@RequestBody BinaryTreeRequest binaryTreeRequest) {

		return new ResponseEntity<>(binaryTreeService.createBinaryTree(binaryTreeRequest), HttpStatus.OK);
	}
}
