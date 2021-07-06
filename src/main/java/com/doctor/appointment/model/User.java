package com.doctor.appointment.model;


import com.doctor.appointment.dto.UserDto;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private int age;
    private String password;

    @ManyToOne(fetch=FetchType.LAZY)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_cart", referencedColumnName = "id")
    private Cart cart;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="profileImage_id", referencedColumnName="id")
    private Media profileImage;

    public User() {
    }

    public User(String email, String name, int age) {
        this.email=email;
        this.name=name;
        this.age=age;
    }

    public User(UserDto userDto) {
        this.name= userDto.getName();
        this.age= userDto.getAge();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role=role;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Media getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Media profileImage) {
        this.profileImage = profileImage;
    }
}
