package sber.assignment.shoppinglist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sber.assignment.shoppinglist.repository.ProductRepository;
import sber.assignment.shoppinglist.entity.Product;

/**
 * Сервис по работе с сущностью EdiblesProduct
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Конструктор c аргументом productRepository
     *
     * @param productRepository объект из репозитория
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Сохраняет продукт в базе данных
     *
     * @param product объект продукта для сохранения
     */
    public void save(Product product) {
        productRepository.save(product);
    }

    /**
     * Удаляет все продукты по айди
     *
     * @param id айди
     */
    public void delete(int id) {
        productRepository.myDeleteByUserId(id);
    }

    /**
     * Ищет продукты в базе данных по айди пользователя
     *
     * @param userId пользовательский айди
     * @return список продуктов для конкретного пользователя
     */
    public List<Product> findByUserId(int userId) {
        return productRepository.findByUserId(userId);
    }

}
