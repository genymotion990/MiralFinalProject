package com.example.hp1.myapplication;

import java.io.Serializable;

/**
 * Created by Hp1 on 27/09/2017.
 */

public class Recipe implements Serializable {
    private long id;
    private String title;
    private String ingredients;
    private String instructions;
    private String imagePath;
    private String category; //cakes or shakes

    public Recipe(long id, String title, String ingredients, String instructions, String imagePath, String category) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imagePath = imagePath;
        this.category = category;
    }
    public Recipe(String title, String ingredients, String instructions, String imagePath, String category) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imagePath = imagePath;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
