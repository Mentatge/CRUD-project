package sber.assignment.shoppinglist.dto;

import lombok.*;

/**
 * Класс, представляющий ответ на запрос списка покупок
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListResponse {
    /**
     * Название продукта
     */
    private String product;
    /**
     * Статус ответа
     */
    private int status;
}

