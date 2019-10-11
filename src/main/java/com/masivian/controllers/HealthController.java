package com.masivian.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The HealthController class.
 *
 * This class helps to verify the application status
 *
 * @author Monica Bajonero
 * @date 10/10/2019
 * @version 0.0.1
 */

@RestController
@RequestMapping(path="/health")
public class HealthController {

    /**
     * Returns an "UP" status when the application is started
     * @return "UP" string
     */
    @GetMapping
    public ResponseEntity<?> health(){
        return new ResponseEntity<>("UP", HttpStatus.OK);
    }
}
