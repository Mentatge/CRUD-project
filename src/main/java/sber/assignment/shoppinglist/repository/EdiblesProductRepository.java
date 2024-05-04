package sber.assignment.shoppinglist.repository;

import sber.assignment.shoppinglist.entity.EdiblesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EdiblesProductRepository extends JpaRepository<EdiblesProduct, Long> {
    @Query(value = "SELECT e FROM EdiblesProduct e WHERE e.userId = :userId ")
    List<EdiblesProduct> findByUserId(@Param("userId") int userId);
}
