package bean;

import common.Category;

import java.util.Objects;

public class Dish {

    private static final long serialVersionUID = 5870107942398243722L;

    private String id;
    private String name;
    private Integer calories;
    private Category category;

    public Dish() {
    }

    public Dish(String id, String name, Integer calories, Category category) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Dish)) {
            return false;
        }

        Dish that = (Dish)o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", calories=" + calories + ", category=" + category + "]";
    }

}