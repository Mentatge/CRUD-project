package sber.assignment.shoppinglist.controller;

import java.time.LocalDateTime;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

import sber.assignment.shoppinglist.dto.GetAndDeleteShoppingListRequest;
import sber.assignment.shoppinglist.dto.InsertAndUpdateShoppingListRequest;
import sber.assignment.shoppinglist.dto.ShoppingListResponse;
import sber.assignment.shoppinglist.service.ShoppingListService;
import sber.assignment.shoppinglist.service.exception.ErrorResponseException;

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

    /**
     * Контролер для Get запросов
     *
     * @param request объект запроса, содержащий необходимые данные
     * @return ответ на запрос и соответствующий HTTP статус
     * @throws Exception в случае возникновения ошибки при обработке запроса
     */
    @GetMapping(value = "/getShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> getShoppingList(@Validated @RequestBody GetAndDeleteShoppingListRequest request) throws Exception {
        log.info("ShoppingListController - getRequest");
        return ResponseEntity.ok().body(shoppingListService.getShoppingList(request));
    }

    /**
     * Контроллер для Post запросов
     *
     * @param request объект запроса, содержащий данные для вставки
     * @return ответ на запрос и соответствующий HTTP статус
     */
    @PostMapping(value = "/insertShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> insertShoppingList(@Validated @RequestBody InsertAndUpdateShoppingListRequest request) {
        log.info("ShoppingListController - insertRequest");
        return ResponseEntity.ok().body(shoppingListService.insertShoppingList(request));
    }

    /**
     * Контроллер для Delete запросов
     *
     * @param request объект запроса, содержащий данные для удаления
     * @return ответ на запрос и соответствующий HTTP статус
     */
    @DeleteMapping(value = "/deleteShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> deleteShoppingList(@Validated @RequestBody GetAndDeleteShoppingListRequest request) {
        log.info("ShoppingListController - deleteRequest");
        return ResponseEntity.ok().body(shoppingListService.deleteShoppingList(request));
    }

    /**
     * Контроллер дл Update запросов
     *
     * @param request объект запроса, содержащий данные для Update
     * @return ответ на запрос и соответствующий HTTP статус
     */
    @PutMapping(value = "/updateShoppingList", produces = "application/json")
    public ResponseEntity<ShoppingListResponse> updateShoppingList(@Validated @RequestBody InsertAndUpdateShoppingListRequest request) {
        log.info("ShoppingListController - updateRequest");
        return ResponseEntity.ok().body(shoppingListService.updateShoppingList(request));
    }

    /**
     * Обработчик исключений для всех типов исключений
     *
     * @param ex исключение, которое нужно обработать
     * @return ответ с ошибкой и соответствующим HTTP статусом
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponseException> handleException(ErrorResponseException ex) {
        ErrorResponseException errorResponse = new ErrorResponseException(LocalDateTime.now(), ex.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
