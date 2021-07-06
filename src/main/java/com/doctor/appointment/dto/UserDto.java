package com.doctor.appointment.dto;

import com.doctor.appointment.model.Cart;
import com.doctor.appointment.model.User;

public class UserDto {
    private String name;
    private int age;
    private Cart cart;

    public UserDto() {
    }

    public UserDto(User user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
