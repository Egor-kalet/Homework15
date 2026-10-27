package org.skypro.skyshop.exceptios;

import java.util.UUID;

public class NoSuchProductException extends  RuntimeException{
    public NoSuchProductException() {
        super("Товар не найден");
    }

    public NoSuchProductException(UUID id) {
        super("Продукт с id: " + id + " не найден");
    }
}
