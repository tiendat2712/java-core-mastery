package bean;

import java.util.Objects;

public class Apple {

    private Integer id;
    private String color;
    private Double weight;
    private String country;

    public Apple() {
    }

    public Apple(Integer id, String color, Double weight, String country) {
        this.id = id;
        this.color = color;
        this.weight = weight;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toLine() {
        return id + ", " + color + ", " + weight + ", " + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Apple)) {
            return false;
        }
        Apple that = (Apple)o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Apple [id=" + id + ", color=" + color + ", weight=" + weight + ", country=" + country + "]";
    }
}
