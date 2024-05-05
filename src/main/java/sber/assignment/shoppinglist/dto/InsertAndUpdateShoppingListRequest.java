package sber.assignment.shoppinglist.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

/**
 * Реализация Insert который будет вызываться и для Delete
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertAndUpdateShoppingListRequest {
    @NonNull
    @Min(1)
    @Max(50)
    private int userId;

    @Size(min = 1, max = 100)
    private String shoppingListName;
}
