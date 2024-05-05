package sber.assignment.shoppinglist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Генерация bd для CRUD
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SHOPPING_LIST", schema = "PUBLIC")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "PRODUCT_NAME")
    @Size(min = 1, max = 255)
    private String productName;

    @Column(name = "COST")
    @Min(0)
    private int cost;

    @Column(name = "COUNT")
    @Min(0)
    private int count;

    @Column(name = "WEIGHT")
    @Min(0)
    private double weight;

    @Column(name = "USER_ID")
    private int userId;
}
