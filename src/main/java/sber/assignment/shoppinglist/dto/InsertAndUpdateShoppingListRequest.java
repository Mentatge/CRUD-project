package sber.assignment.shoppinglist.dto;

import lombok.*;

/**
 * Реализация инсерта
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertAndUpdateShoppingListRequest {
    @NonNull
    private int userId;
    private String shoppingListName;
}
