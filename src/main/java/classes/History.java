package classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer transactionsId;
    @Column
    private Integer clientId;
    @Column
    private Integer productId;
    @Column
    private Integer quantity;

    public History(Integer clientId, Integer productId, Integer quantity) {
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public History() {
    }

    public Integer getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Integer transactions_id) {
        this.transactionsId = transactions_id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer client_id) {
        this.clientId = client_id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer product_id) {
        this.productId = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;

        return Objects.equals(transactionsId, history.transactionsId) &&
                Objects.equals(clientId, history.clientId) &&
                Objects.equals(productId, history.productId) &&
                Objects.equals(quantity, history.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transactionsId, clientId, productId, quantity);
    }

    @Override
    public String toString() {
        return "History{" +
                "transactions_id=" + transactionsId +
                ", client_id=" + clientId +
                ", product_id=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}