package com.doctor.appointment.model;


import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String reivew;
    private Integer stars;

    @ManyToOne
    @JoinColumn(name="Product_ID", nullable = false)
    private Product product;


    public Review() {
    }

    public Review(User user, String reivew, Integer stars) {
        this.user = user;
        this.reivew = reivew;
        this.stars = stars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReivew() {
        return reivew;
    }

    public void setReivew(String reivew) {
        this.reivew = reivew;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
