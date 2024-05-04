package controller;

import dto.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.ShoppingListService;

@RestController
@Log4j2
public class ShoppingListController {

    private ShoppingListService shoppingListService;
    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    //написать эксепшен хендлер, если айди не валидный и в базе ничего не найдено
    @PostMapping(value = "/getShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> getShoppingList(@Validated @RequestBody ShoppingListRequest request) throws Exception {
        return ResponseEntity.ok().body(shoppingListService.getShoppingList(request));
    }
}
