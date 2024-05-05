package sber.assignment.shoppinglist.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Генерация bd для CRUD
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SHOPPING_LIST", schema = "PUBLIC")
public class EdiblesProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "COST")
    private int cost;

    @Column(name = "COUNT")
    private int count;

    @Column(name = "WEIGHT")
    private double weight;

    @Column(name = "USER_ID")
    private int userId;

}
