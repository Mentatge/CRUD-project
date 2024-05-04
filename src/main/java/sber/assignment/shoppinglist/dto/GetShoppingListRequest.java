package sber.assignment.shoppinglist.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetShoppingListRequest {
    @NonNull
    private int userId;
}
