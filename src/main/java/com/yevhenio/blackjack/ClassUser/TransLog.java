package com.yevhenio.blackjack.ClassUser;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eugene on 05.10.15.
 */
//Entity class for transactions
@Entity
@Table(name = "Transactions")
public class TransLog implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idNum;
    @Column(name = "id")
    private int id;
    @Column(name = "value")
    private int value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TransLog(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public TransLog() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransLog transLog = (TransLog) o;

        if (id != transLog.id) return false;
        if (value != transLog.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "TransLog{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
