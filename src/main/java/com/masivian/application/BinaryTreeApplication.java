package com.masivian.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Binary Tree Application class.
 *
 * This class inits the application
 *
 * @author Monica Bajonero
 * @date 10/10/2019
 * @version 0.0.1
 */
@ComponentScan(basePackages={"com.masivian"})
@SpringBootApplication
public class BinaryTreeApplication {

    /**
     * The run method
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BinaryTreeApplication.class, args);
    }
}
