package sber.assignment.shoppinglist.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAndDeleteShoppingListRequest {
    @NonNull
    private int userId;
}
