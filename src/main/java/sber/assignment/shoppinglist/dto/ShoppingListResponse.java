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
    private String product;
    private int status;
}

