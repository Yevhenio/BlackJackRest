package com.yevhenio.blackjack.classUser;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eugene on 05.10.15.
 */

@Entity
@Table(name = "UserDB")
public class User implements Serializable {
    @Column(name = "wallet")
    private int wallet;
    @Id
    @Column(name = "id")
    @PrimaryKeyJoinColumn

    private int id;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "wallet=" + wallet +
                ", id=" + id +
                '}';
    }

    ;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (wallet != user.wallet) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wallet;
        result = 31 * result + id;
        return result;
    }
}
