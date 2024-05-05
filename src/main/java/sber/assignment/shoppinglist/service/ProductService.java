package sber.assignment.shoppinglist.service;


import sber.assignment.shoppinglist.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sber.assignment.shoppinglist.repository.ProductRepository;

import java.util.List;

/**
 * Сервис по работе с сущностью EdiblesProduct
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Конструктор
     *
     * @param productRepository объект из репозитория
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.myDeleteByUserId(id);
    }

    public List<Product> findByUserId(int userId) {
        return productRepository.findByUserId(userId);
    }

}
