package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


import java.util.Scanner;

@Component
public class NorthwindApp implements CommandLineRunner {

    @Autowired
    public SimpleProductDao simpleProductDao;
    Scanner scanner = new Scanner(System.in);

    public NorthwindApp(SimpleProductDao simpleProductDao) {
        this.simpleProductDao = simpleProductDao;
    }

    @Override
    public void run(String... args) throws Exception {
        String input = " ";

        do  {

            System.out.println("""
                    What would you like to do?
                    1) Lists products
                    2) Add Products
                    0) Exit
                    """);
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    simpleProductDao.getAll().forEach(System.out::println);
                    break;
                case "2":
                    System.out.println("Enter product ID: ");
                    int productID = scanner.nextInt();
                    scanner.nextLine();
                    String productName = scanner.nextLine();
                    String categoryName = scanner.nextLine();
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Product addProduct = new Product(productID, productName, categoryName, price);
                    simpleProductDao.add(addProduct);
                    break;
                case "0":
                    scanner.close();
                    System.exit(0);

            }
        } while (!input.equals("0"));
        }

    }

