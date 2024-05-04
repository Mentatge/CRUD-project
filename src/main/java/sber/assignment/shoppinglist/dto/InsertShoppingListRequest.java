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
public class InsertShoppingListRequest {
    @NonNull
    private int userId;
    private String shoppingListName;

}
