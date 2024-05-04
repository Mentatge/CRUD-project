package sber.assignment.shoppinglist.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Класс, представляющий ответ на запрос списка покупок
 */
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

