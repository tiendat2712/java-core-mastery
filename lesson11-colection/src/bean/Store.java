package bean;

import java.util.Objects;

public class Store {

    private Integer id;
    private String name;

    public Store() {
    }

    public Store(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // map --> put(K, V)
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    // list --> remove(o), contains(o)
    // map --> put(K, V)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Store)) {
            return false;
        }

        Store that = (Store) o;

        return Objects.equals(this.getId(), that.getId())
                && Objects.equals(this.getName(), that.getName());
    }

    @Override
    public String toString() {
        return "Store [id=" + id + ", name=" + name + "]";
    }
}
