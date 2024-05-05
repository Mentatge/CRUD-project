package sber.assignment.shoppinglist.service;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.HttpStatus;

import sber.assignment.shoppinglist.dto.GetAndDeleteShoppingListRequest;
import sber.assignment.shoppinglist.dto.InsertAndUpdateShoppingListRequest;
import sber.assignment.shoppinglist.dto.ShoppingListResponse;
import sber.assignment.shoppinglist.entity.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ShoppingListServiceTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ShoppingListService shoppingListService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetShoppingList() throws JsonProcessingException {
        // Given
        GetAndDeleteShoppingListRequest request = new GetAndDeleteShoppingListRequest();
        request.setUserId(1);

        List<Product> productList = Collections.singletonList(new Product());

        when(productService.findByUserId(request.getUserId())).thenReturn(productList);

        ShoppingListResponse response = shoppingListService.getShoppingList(request);

        assertEquals(81, response.getProduct().length());
    }

    @Test
    public void testInsertShoppingList() throws JsonProcessingException {
        InsertAndUpdateShoppingListRequest request = new InsertAndUpdateShoppingListRequest();
        request.setUserId(1);
        request.setShoppingListName("test1");

        ShoppingListResponse response = shoppingListService.insertShoppingList(request);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testDeleteShoppingList() {
        GetAndDeleteShoppingListRequest request = new GetAndDeleteShoppingListRequest();
        request.setUserId(1);

        ShoppingListResponse response = shoppingListService.deleteShoppingList(request);

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

}