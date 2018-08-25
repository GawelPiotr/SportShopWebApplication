package classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String colour;
    @Column
    private Integer size;
    @Column
    private Integer quantity;
    @Column
    private Integer reserved;

    public Product(String name, String type, String colour, Integer size, Integer quantity, Integer reserved) {
        this.name = name;
        this.type = type;
        this.colour = colour;
        this.size = size;
        this.quantity = quantity;
        this.reserved = reserved;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getReserved() {
        return reserved;
    }

    public void setReserved(Integer reserved) {
        this.reserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(product_id, product.product_id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(type, product.type) &&
                Objects.equals(colour, product.colour) &&
                Objects.equals(size, product.size) &&
                Objects.equals(quantity, product.quantity) &&
                Objects.equals(reserved, product.reserved);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product_id, name, type, colour, size, quantity, reserved);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                ", reserved=" + reserved +
                '}';
    }
}
