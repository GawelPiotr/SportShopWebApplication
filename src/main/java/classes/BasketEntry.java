package classes;

import java.util.Objects;

public class BasketEntry {
    private Integer productId;
    private Integer reservedQuantity;

    public BasketEntry(Integer productId, Integer reservedQuantity) {
        this.productId = productId;
        this.reservedQuantity = reservedQuantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(Integer reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketEntry that = (BasketEntry) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(reservedQuantity, that.reservedQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, reservedQuantity);
    }

    @Override
    public String toString() {
        return "BasketEntry{" +
                "productId=" + productId +
                ", reservedQuantity=" + reservedQuantity +
                '}';
    }
}
