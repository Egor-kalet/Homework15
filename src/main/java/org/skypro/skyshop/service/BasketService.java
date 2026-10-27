package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptios.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BasketService {

    private final StorageService storageService;
    private final ProductBasket productBasket;

    public BasketService(StorageService storageService, ProductBasket productBasket) {
        this.storageService = storageService;
        this.productBasket = productBasket;
    }

    public void addProduct(UUID id){
        if (!storageService.getProductById(id).isPresent()){
            throw new NoSuchProductException(id);
        }
        productBasket.addProduct(id);
    }

    public UserBasket getUserBasket(){
        Map<UUID, Integer> basket = productBasket.getBasket();

        List<BasketItem> items = basket.entrySet().stream()
                .map(e -> new BasketItem(storageService.getProductById(e.getKey()).orElseThrow(() -> new NoSuchProductException()),e.getValue()))
                .toList();
        return new UserBasket(items);
    }

}
