package sber.assignment.shoppinglist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SHOPPING_LIST")
public class EdiblesProduct {

    @Id
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
