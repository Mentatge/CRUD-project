package dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListRequest {
    /**
     * индификатор пользователя для поиска его корзины в БД
     */
    @NonNull
    private int id;
}
