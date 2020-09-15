package ru.cherniak.spring.hw_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.cherniak.spring.hw_01.Util.printWarning;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> cartProduct;
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        cartProduct = new ArrayList<>();
    }

    public void addProduct(long id) {
        Product product = productRepository.getProduct(id);
        if (product == null) {
            printWarning(id);
            return;
        }
        cartProduct.add(product);
    }

    public void removeProduct(long id) {
        Product product = getProduct(id);
        if (product == null) {
            printWarning(id);
            return;
        }
        cartProduct.remove(product);
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(cartProduct);
    }

    public Product getProduct(long id) {
        return cartProduct.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

//    private void printWarning(long id) {
//        System.out.println("Warning! Product id = " + id + " is not exists");
//    }
}
