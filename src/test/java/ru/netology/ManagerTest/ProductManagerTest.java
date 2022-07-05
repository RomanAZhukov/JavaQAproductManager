package ru.netology.ManagerTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ProductRepo.ProductRepo;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphones;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Мастер и Маргарита", "М. Булгаков", 500);
    Product book2 = new Book(2, "Остров окровищ", "Р. Стивенсон", 400);
    Product smartphone1 = new Smartphones(3, "Xperia 5", "Sony", 5000);
    Product smartphone2 = new Smartphones(4, "Honor 50", "Huawei", 3000);

    @BeforeEach
    public void setUp() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldAddProduct() {

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText() {

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Мастер");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNumberInName() {

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("5");

        assertArrayEquals(expected, actual);
    }
}