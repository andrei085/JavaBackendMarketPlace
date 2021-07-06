package com.doctor.appointment.dto;

public class ProductDto {

    private long id;
    private String name;
    private double price;
    private String category;
    private String description;

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
