package com.pluralsight.NorthwindTradersSpringBoot.dao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private List <Product> products = new ArrayList<>();

    @Autowired
    public SimpleProductDao() {
        add(new Product(1, "Backrooms", "Object", 200.00));
        add(new Product(2, "Funrooms", "Fun Object", 230.00));
        add(new Product(3, "Apple Air Pods", "Electronics", 200.00));
        add(new Product(4, "Ps5", "Electronics", 200.00));
        add(new Product(5, "Retractable Staff", "Toys", 200.00));
        add(new Product(6, "Action figure", "Toys", 200.00));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }



    @Override
    public List<Product> getAll() {
        ArrayList<Product> products1 = new ArrayList<>();

        for (Product p : products) {
            products1.add(p);
        }
        return products1;
    }
}
