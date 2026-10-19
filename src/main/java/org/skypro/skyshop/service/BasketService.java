package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

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
            throw new IllegalArgumentException("Продукт с id: " + id + " не найден");
        }
        productBasket.addProduct(id);
    }

    public UserBasket getUserBasket(){
        Map<UUID, Integer> basket = productBasket.getBasket();

        List<BasketItem> items = basket.entrySet().stream()
                .map(e -> new BasketItem(storageService.getProductById(e.getKey()).orElseThrow(),e.getValue()))
                .toList();


        return new UserBasket(items);
    }
}
