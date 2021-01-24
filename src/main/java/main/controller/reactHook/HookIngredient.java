package main.controller.reactHook;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "hookIngredients")
public class HookIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int amount;

    public HookIngredient() {
    }

    public HookIngredient(String title, int amount) {
        this.title = title;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                '}';
    }
}
