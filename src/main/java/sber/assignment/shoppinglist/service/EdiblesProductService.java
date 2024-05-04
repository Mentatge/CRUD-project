package sber.assignment.shoppinglist.service;


import sber.assignment.shoppinglist.entity.EdiblesProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sber.assignment.shoppinglist.repository.EdiblesProductRepository;

import java.util.List;

/**
 * Сервис по работе с сущностью EdiblesProduct
 */
@Service
public class EdiblesProductService {
    private final EdiblesProductRepository ediblesProductRepository;

    @Autowired
    public EdiblesProductService(EdiblesProductRepository ediblesProductRepository) {
        this.ediblesProductRepository = ediblesProductRepository;
    }

    public List<EdiblesProduct> findByUserId(int userId) {
        return ediblesProductRepository.findByUserId(userId);
    }


}
