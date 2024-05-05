package sber.assignment.shoppinglist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sber.assignment.shoppinglist.entity.Product;

/**
 * Репозиторий для работы со списком продуктов
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT e FROM Product e WHERE e.userId = :userId ")
    List<Product> findByUserId(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product e WHERE e.userId = :userId")
    void myDeleteByUserId(@Param("userId") int userId);
}
