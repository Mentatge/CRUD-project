package sber.assignment.shoppinglist.service;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sber.assignment.shoppinglist.dto.GetShoppingListRequest;
import sber.assignment.shoppinglist.dto.InsertShoppingListRequest;
import sber.assignment.shoppinglist.dto.ShoppingListResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sber.assignment.shoppinglist.entity.EdiblesProduct;

@Service
@Log4j2
public class ShoppingListService {
    /**
     * Экземпляр по работе с продуктами
     */
    private final EdiblesProductService ediblesProductService;

    @Autowired
    public ShoppingListService(EdiblesProductService ediblesProductService) {
        this.ediblesProductService = ediblesProductService;
    }

    /**
     * метод для подготовки ответа по списку покупок для фронта
     *
     * @param request - запрос от фронта с id списка покупок клиента
     * @return список покупок клиента
     */
    public ShoppingListResponse getShoppingList(GetShoppingListRequest request) throws JsonProcessingException {
        log.info("ShoppingListResponse - Get Request");
        return ShoppingListResponse
                .builder()
                .product(getShoppingListJson(request))
                .build();
    }

    /**
     * Вспомогательный метод для getShoppingList для перевода request в строку
     *
     * @param request запрос
     * @return возвращает результат в виде строки
     * @throws JsonProcessingException
     */
    public String getShoppingListJson(GetShoppingListRequest request) throws JsonProcessingException {
        String result;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        log.info("ShoppingListResponse - try to Mapping Json");
        result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ediblesProductService.findByUserId(request.getUserId()));
        log.info("ShoppingListResponse - Successfully Mapped Json");
        return result;
    }

    /**
     * Вставка в список покупок элемента на основе запроса
     *
     * @param request запрос
     * @return ответ о статусе выполнения операции
     */

    public ShoppingListResponse insertShoppingList(InsertShoppingListRequest request) {
        log.info("ShoppingListResponse - insert Request");
        EdiblesProduct ediblesProduct = new EdiblesProduct();
        ediblesProduct.setUserId(request.getUserId());
        ediblesProduct.setProductName(request.getShoppingListName());
        ediblesProductService.save(ediblesProduct);
        return ShoppingListResponse
                .builder()
                .status(200)
                .build();
    }

    /**
     * Удалить список покупок на основе запроса.
     *
     * @param request запрос на удаление списка покупок
     * @return ответ о статусе выполнения операции
     */
    public ShoppingListResponse deleteShoppingList(GetShoppingListRequest request) {
        log.info("ShoppingListResponse - delete Request");
        EdiblesProduct ediblesProduct = new EdiblesProduct();
        ediblesProduct.setUserId(request.getUserId());
        ediblesProductService.delete(request.getUserId());
        return ShoppingListResponse
                .builder()
                .status(200)
                .build();
    }
}
