package ru.netology.RepoTest;

import org.junit.jupiter.api.Test;
import ru.netology.ProductRepo.ProductRepo;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphones;
import ru.netology.manager.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {
    ProductRepo repo = new ProductRepo();


    Product book1 = new Book(1, "Мастер и Маргарита", "М. Булгаков", 500);
    Product book2 = new Book(2, "Остров окровищ", "Р. Стивенсон", 400);
    Product smartphone1 = new Smartphones(3, "Xperia 5", "Sony", 5000);
    Product smartphone2 = new Smartphones(4, "Honor 50", "Huawei", 3000);

    @Test

    public void emptyRepo() {
        Product[] expected = {};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSaveOneProduct() {
        repo.save(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSaveSeveralProducts() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);

        Product[] expected = {book1, book2, smartphone1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldRemoveById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.removeById(2);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test

    public void shouldRemoveByNoId() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);


        assertThrows(NotFoundException.class, () -> repo.removeById(5));
    }


    @Test

    public void shouldRemoveByNoId1() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);


        assertThrows(NotFoundException.class, () -> repo.removeById(-1));


    }

}
