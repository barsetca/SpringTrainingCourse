package ru.cherniak.spring.hw_01;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.cherniak.spring.hw_01.Util.printWarning;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Гвоздь", 1));
        products.add(new Product(2L, "Болт", 10));
        products.add(new Product(3L, "Гайка", 5));
        products.add(new Product(4L, "Скоба", 15));
        products.add(new Product(5L, "Шуруп", 2));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product getProduct(long id) {
        Product product = products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (product == null) {
            printWarning(id);
        }
        return product;
    }
}
