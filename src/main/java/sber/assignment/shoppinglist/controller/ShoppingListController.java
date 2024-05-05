package sber.assignment.shoppinglist.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sber.assignment.shoppinglist.dto.*;
import sber.assignment.shoppinglist.service.ShoppingListService;
import sber.assignment.shoppinglist.service.exception.ErrorResponseException;

import java.time.LocalDateTime;

/**
 * Контроллер для приложения
 */

@RestController
@Log4j2
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping(value = "/getShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> getShoppingList(@Validated @RequestBody GetAndDeleteShoppingListRequest request) throws Exception {
        log.info("ShoppingListController - getRequest");
        return ResponseEntity.ok().body(shoppingListService.getShoppingList(request));
    }

    @PostMapping(value = "/insertShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> insertShoppingList(@Validated @RequestBody InsertAndUpdateShoppingListRequest request) {
        log.info("ShoppingListController - insertRequest");
        return ResponseEntity.ok().body(shoppingListService.insertShoppingList(request));
    }

    @DeleteMapping(value = "/deleteShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> deleteShoppingList(@Validated @RequestBody GetAndDeleteShoppingListRequest request) {
        log.info("ShoppingListController - deleteRequest");
        return ResponseEntity.ok().body(shoppingListService.deleteShoppingList(request));
    }

    @PutMapping(value = "/updateShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> updateShoppingList(@Validated @RequestBody InsertAndUpdateShoppingListRequest request) {
        log.info("ShoppingListController - updateRequest");
        return ResponseEntity.ok().body(shoppingListService.updateShoppingList(request));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponseException> handleException(ErrorResponseException ex) {
        ErrorResponseException errorResponse = new ErrorResponseException(LocalDateTime.now(), ex.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
