package com.yevhenio.blackjack.servicePack;

import com.yevhenio.blackjack.classUser.TransLog;
import com.yevhenio.blackjack.classUser.User;

import javax.ws.rs.*;

/**
 * Created by eugene on 05.10.15.
 */
//Service class for user
@Path("/fill")
public class UserRestService {
    static UserDAO ud = new UserDAO();
   public static int currentUser;
   public static User player;
    public int bet;

    //adding money to player`s wallet
    @PUT
    @Path("/{id}/{value}")
    public void fillWallet(
            @PathParam("id") int id,
            @PathParam("value") int sum) {
        User user = ud.getFromBase(id);
        System.out.println(user.getId() + " " + user.getWallet());
        int total = user.getWallet() + sum;
        user.setWallet(total);
        System.out.println(total);
        ud.updateUser(user);
        ud.addTrans(new TransLog(user.getId(), sum));
    }

    public void winTheBet() {
        player.setWallet(player.getWallet() + bet * 2);
        ud.updateUser(player);
        ud.addTrans(new TransLog(player.getId(), bet * 2));
        bet = 0;
    }

    public void pushTheBet() {
        player.setWallet(player.getWallet() + bet);
        ud.updateUser(player);
        ud.addTrans(new TransLog(player.getId(), bet));
        bet = 0;
    }

    public void blackJack() {
        int half = bet / 2;
        player.setWallet(player.getWallet() + bet * 2 + half);
        ud.updateUser(player);
        ud.addTrans(new TransLog(player.getId(), bet));
        bet = 0;
    }

    //getting user from DB by his ID
    @GET
    @Path("/{user}")
    public User getUser(
            @PathParam("user") int id) {
        User u = ud.getFromBase(id);
        currentUser = id;
        player = u;
        return u;
    }

    //setting a bet for current game
    @POST
    @Path("/bet/{value}")
    public void setBet(@PathParam("value") int value) {
        fillWallet(currentUser, -value);
        bet = value;

    }

}


