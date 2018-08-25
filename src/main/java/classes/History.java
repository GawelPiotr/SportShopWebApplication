package main.java.classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactions_id;
    @Column
    private Integer client_id;
    @Column
    private Integer product_id;
    @Column
    private Integer quantity;

    public History(Integer client_id, Integer product_id, Integer quantity) {
        this.client_id = client_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Integer getTransactions_id() {
        return transactions_id;
    }

    public void setTransactions_id(Integer transactions_id) {
        this.transactions_id = transactions_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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
        return Objects.equals(transactions_id, history.transactions_id) &&
                Objects.equals(client_id, history.client_id) &&
                Objects.equals(product_id, history.product_id) &&
                Objects.equals(quantity, history.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transactions_id, client_id, product_id, quantity);
    }

    @Override
    public String toString() {
        return "History{" +
                "transactions_id=" + transactions_id +
                ", client_id=" + client_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}
