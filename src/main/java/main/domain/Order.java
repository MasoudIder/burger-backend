package main.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int salad;
    private int bacon;
    private int cheese;
    private int meat;

    private double price;

    private String customer;
    private String email;
    private String phone;
    private String delivery;

    public Order() {
    }

    public Order(int salad, int bacon, int cheese, int meat, double price, String customer, String email, String phone, String delivery) {
        this.salad = salad;
        this.bacon = bacon;
        this.cheese = cheese;
        this.meat = meat;
        this.price = price;
        this.customer = customer;
        this.email = email;
        this.phone = phone;
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", salad=" + salad +
                ", bacon=" + bacon +
                ", cheese=" + cheese +
                ", meat=" + meat +
                ", price=" + price +
                ", customer='" + customer + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", delivery='" + delivery + '\'' +
                '}';
    }
}
