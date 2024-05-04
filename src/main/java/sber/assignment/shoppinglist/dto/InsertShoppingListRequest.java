package sber.assignment.shoppinglist.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertShoppingListRequest {
        /**
         * индификатор пользователя для вставки его корзины в БД
         */
        @NonNull
        private int userId;
        private String shoppingListName;
}
