package main.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
@Getter
@Setter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int salad;
    private int bacon;
    private int cheese;
    private int meat;

    public Ingredient() {
    }

    public Ingredient(int salad, int bacon, int cheese, int meat) {
        this.salad = salad;
        this.bacon = bacon;
        this.cheese = cheese;
        this.meat = meat;
    }
}
