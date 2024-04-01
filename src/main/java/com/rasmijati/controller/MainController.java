/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.repository.ProductRepository;
import com.rasmijati.repository.UserRepository;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MainController {

    private static UserController userController;
    private static UserRepository userRepository;

    private static ProductController productController;
    private static ProductRepository productRepository;

    public static void main(String[] args) {
        userController = new UserController();
        userRepository = new UserRepository();
        productController = new ProductController();
        productRepository = new ProductRepository();
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println(" Select Operation to Perform ");
            System.out.println("Enter 1 for User ");
            System.out.println("Enter 2 for Product ");
            System.out.println("Enter 3 for Exit ");

            System.out.println("Enter your choice : ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    userController.OperationSelection(userRepository);
                    break;
                case "2":
                    productController.OperationSelection(productRepository);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid option !! please choose another option!!");
                    break;
            }
        } while (!choice.equals("0"));

    }
}
