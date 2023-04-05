package ru.netology.exceptions;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Product 1", 10_000);
        Product product2 = new Product(2, "Product 2", 20_000);
        ShopRepository repository = new ShopRepository();

        try {
            //repository.removeById(-100);
            repository.add(product1);
            repository.add(product2);
            repository.add(product1);
        } catch (NegativeArraySizeException e) {
            System.out.println("ERROR");
        }
    }
}