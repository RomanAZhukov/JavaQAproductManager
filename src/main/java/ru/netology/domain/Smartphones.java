package ru.netology.domain;

public class Smartphones extends Product {
    private String brand;
    private int name;

    public Smartphones(int id, String name, String brand, int price) {
        super(id, name, price);
        this.brand = brand;


    }


}

