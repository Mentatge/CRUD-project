package sber.assignment.shoppinglist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

/**
 * Класс, представляющий ответ на запрос списка покупок
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListResponse {
    @Size(min = 1)
    private String product;

    @Min(0)
    @Max(1000)
    private int status;
}

