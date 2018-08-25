package main.java.classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer client_id;
    @Column
    private String nick;


    public Client(String nick) {
        this.nick = nick;
    }


    public Integer getId() {
        return client_id;
    }

    public void setId(Integer id) {
        this.client_id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(client_id, client.client_id) &&
                Objects.equals(nick, client.nick);
    }

    @Override
    public int hashCode() {

        return Objects.hash(client_id, nick);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + client_id +
                ", nick='" + nick + '\'' +
                '}';
    }
}
