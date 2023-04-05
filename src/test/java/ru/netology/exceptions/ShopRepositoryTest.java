package ru.netology.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Product 1", 10_000);
    Product product2 = new Product(2, "Product 2", 20_000);
    ShopRepository repository = new ShopRepository();

    @BeforeEach
    public void setup() {
        repository.add(product1);
        repository.add(product2);
    }

    // 1) Тест на успешное удаление товара

    @Test
    public void shouldRemoveExistingProduct() {
        repository.removeById(1);
        Product[] expected = {product2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // 2) Тест на генерацию исключения NotFoundException при попытке удаления несуществующего товара

    @Test
    public void shouldThrowNotFoundExceptionWhenRemovingNonexistentProduct() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }

    // 3) Тест успешное добавление товара

    @Test
    void shouldAddProduct() {
        Product product3 = new Product(3, "Product 3", 30_000);
        repository.add(product3);

        Product[] expected= {product1, product2, product3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // 4) Тест на генерацию AlreadyExistsException при попытке добавить элемент с повторяющимся ID

    @Test
    void shouldThrowAlreadyExistsExceptionWhenAddExistsId() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(product1);
        });
    }
}


