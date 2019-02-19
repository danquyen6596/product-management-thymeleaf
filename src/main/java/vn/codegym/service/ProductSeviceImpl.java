package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSeviceImpl implements ProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1,"MouseTP01", 149000, "USA"));
        productMap.put(2, new Product(2,"MouseTP02", 249000, "US"));
        productMap.put(3, new Product(3,"Display 14inch", 1439000, "FR"));
        productMap.put(4, new Product(4,"Ram 1366 4GB", 549000, "China"));
        productMap.put(5, new Product(5,"HDD 500G", 499000, "Korea"));
        productMap.put(6, new Product(6,"SSD 256GB", 949000, "JP"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getCode(), product);
    }

    @Override
    public Product findByCode(int code) {
        return productMap.get(code);
    }

    @Override
    public void delete(int code) {
        productMap.remove(code);
    }

    @Override
    public void update(int code, Product product) {
        productMap.put(code, product);
    }
}
