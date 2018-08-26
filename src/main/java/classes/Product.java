package classes;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Product {

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
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

    public Product(String type, String colour, Integer size, Integer quantity, Integer reserved) {
        this.type = type;
        this.colour = colour;
        this.size = size;
        this.quantity = quantity;
        this.reserved = reserved;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
        return Objects.equals(productId, product.productId) &&
                Objects.equals(type, product.type) &&
                Objects.equals(colour, product.colour) &&
                Objects.equals(size, product.size) &&
                Objects.equals(quantity, product.quantity) &&
                Objects.equals(reserved, product.reserved);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, type, colour, size, quantity, reserved);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + productId +
                ", type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                ", reserved=" + reserved +
                '}';
    }
}
