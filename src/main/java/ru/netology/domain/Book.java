package ru.netology.domain;

public class Book extends Product {
    private String author;
    private int name;

    public Book(int id, String name, String author, int price) {
        super(id, name, price);
        this.author = author;


    }






}
