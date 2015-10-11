package com.yevhenio.blackjack.servicePack;

import com.yevhenio.blackjack.ClassUser.TransLog;
import com.yevhenio.blackjack.ClassUser.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by eugene on 05.10.15.
 */
public class UserDAO {

    private static Session session = HibSingle.getInstance().getSession();

    public void addUser(User user) {
        Transaction tx = session.beginTransaction();

        try {

            session.save(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getFromBase(int id) {
        Transaction tx = session.beginTransaction();

        User temp = (User) session.get(User.class, id);

        tx.commit();
        return temp;
    }

    public void updateUser(User user) {
        Transaction tx = session.beginTransaction();


        session.update(user);
        tx.commit();

    }
//Adding transaction to DB
    public void addTrans(TransLog transLog) {
        Transaction tx = session.beginTransaction();

        try {

            session.save(transLog);
            transLog.toString();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
