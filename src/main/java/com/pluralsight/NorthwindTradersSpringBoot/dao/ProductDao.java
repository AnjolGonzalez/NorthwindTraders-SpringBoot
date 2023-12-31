package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import java.util.List;

public interface ProductDao {
    public void add(Product product);
    public List<Product> getAll();
}
