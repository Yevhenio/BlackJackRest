package com.yevhenio.blackjack.servicePack;

import com.yevhenio.blackjack.ClassUser.TransLog;
import com.yevhenio.blackjack.ClassUser.User;

/**
 * Created by eugene on 05.10.15.
 */
public class UserService {
    UserDAO ud = new UserDAO();

    public void fillWallet(User user, int sum) {
        System.out.println(user.getId() + " " + user.getWallet());
        int total = user.getWallet() + sum;
        user.setWallet(total);
        System.out.println(total);
        total = 0;
        ud.updateUser(user);
        ud.addTrans(new TransLog(user.getId(), sum));
    }

}
