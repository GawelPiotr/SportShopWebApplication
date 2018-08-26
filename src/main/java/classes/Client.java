package classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @Column
    private String nick;


    public Client(String nick) {
        this.nick = nick;
    }

    public Client() {
    }


    public Integer getId() {
        return clientId;
    }

    public void setId(Integer id) {
        this.clientId = id;
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
        return Objects.equals(clientId, client.clientId) &&
                Objects.equals(nick, client.nick);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clientId, nick);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + clientId +
                ", nick='" + nick + '\'' +
                '}';
    }
}
