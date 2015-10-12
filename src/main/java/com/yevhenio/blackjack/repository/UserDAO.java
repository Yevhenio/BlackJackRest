package com.yevhenio.blackjack.repository;

import com.yevhenio.blackjack.classUser.TransLog;
import com.yevhenio.blackjack.classUser.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 05.10.15.
 */
public class UserDAO {

    private static Session session = HibSingle.getInstance().getSession();

    public void addUser(User user) {
        Transaction tx = session.beginTransaction();

        try {

            session.saveOrUpdate(user);
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

    public List getTransactions(int id) {
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(TransLog.class);
        List<TransLog> list = criteria.list();
        tx.commit();
        ArrayList<TransLog> arr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                arr.add(list.get(i));

            }


        }
        return arr;
    }
}
