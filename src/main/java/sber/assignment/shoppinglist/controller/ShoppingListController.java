package sber.assignment.shoppinglist.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sber.assignment.shoppinglist.dto.*;
import sber.assignment.shoppinglist.service.ShoppingListService;

@RestController
@Log4j2
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    //написать эксепшен хендлер, если айди не валидный и в базе ничего не найдено
    @PostMapping(value = "/getShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> getShoppingList(@Validated @RequestBody GetShoppingListRequest request) throws Exception {
        log.info("ShoppingListController - getRequest");
        return ResponseEntity.ok().body(shoppingListService.getShoppingList(request));
    }

    @PostMapping(value = "/insertShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> insertShoppingList(@Validated @RequestBody InsertShoppingListRequest request) throws Exception {
        log.info("ShoppingListController - insertRequest");
        return ResponseEntity.ok().body(shoppingListService.insertShoppingList(request));
    }

    @DeleteMapping(value = "/deleteShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> deleteShoppingList(@Validated @RequestBody GetShoppingListRequest request) throws Exception {
        log.info("ShoppingListController - deleteRequest");
        return ResponseEntity.ok().body(shoppingListService.deleteShoppingList(request));
    }

}
