package sber.assignment.shoppinglist.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import sber.assignment.shoppinglist.entity.EdiblesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Репозиторий для работы со списком продуктов
 */
public interface ProductRepository extends JpaRepository<EdiblesProduct, Long> {
    @Query(value = "SELECT e FROM EdiblesProduct e WHERE e.userId = :userId ")
    List<EdiblesProduct> findByUserId(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM EdiblesProduct e WHERE e.userId = :userId")
    void myDeleteByUserId(@Param("userId") int userId);
}
