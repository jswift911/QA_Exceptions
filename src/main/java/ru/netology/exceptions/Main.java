package ru.netology.exceptions;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1, "Product 1", 50_000);
        ShopRepository repository = new ShopRepository();

        try {
            repository.removeById(-100);
        } catch (NegativeArraySizeException e) {
            System.out.println("ERROR");
        }
    }
}