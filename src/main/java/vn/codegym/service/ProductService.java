package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findByCode(int code);

    void delete(int code);

    void update(int code, Product product);

}
