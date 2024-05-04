package controller;

import dto.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ShoppingListController {

    @PostMapping(value = "/getShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> getShoppingList(@Validated @RequestBody ShoppingListRequest request) {

    }
}
