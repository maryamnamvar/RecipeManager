package com.recipeapplication.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Recipe")
public class Recipe implements Serializable {

    private static final long serialVersionUID = 2635784451296532154L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cooking_instruction", nullable = false)
    private String cookingInstruction;

    @Column(name = "num_of_people", nullable = false)
    private int numberOfPeople;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "vegetarian")
    private Boolean vegetarian;

    @ElementCollection(targetClass = String.class)
    @Column(name = "ingredients")
    private List<String> ingredients;

    public Recipe() {
    }

    public Recipe(String name, String cookingInstruction, int numberOfPeople, LocalDateTime creationDate, List<String> ingredients) {
        this.name = name;
        this.cookingInstruction = cookingInstruction;
        this.numberOfPeople = numberOfPeople;
        this.creationDate = creationDate;
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCookingInstruction() {
        return cookingInstruction;
    }

    public void setCookingInstruction(String cookingInstruction) {
        this.cookingInstruction = cookingInstruction;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}