package sber.assignment.shoppinglist.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAndDeleteShoppingListRequest {
    @NonNull
    @Min(1)
    @Max(1024)
    private int userId;
}
