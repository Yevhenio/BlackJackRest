package com.yevhenio.blackjack.servicePack;

import com.yevhenio.blackjack.ClassUser.TransLog;
import com.yevhenio.blackjack.ClassUser.User;

import javax.ws.rs.*;

/**
 * Created by eugene on 05.10.15.
 */
//Service class for user
@Path("/fill")
public class UserRestService {
    static UserDAO ud = new UserDAO();
    int currentUser;
    public int bet;

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

    @GET
    @Path("/{user}")
    @Produces("text/plain")
    public User getUser(
            @PathParam("user") int id) {
        User u = ud.getFromBase(id);
        currentUser = id;
        return u;
    }

    @POST
    @Path("/bet/{value}")
    public void setBet(@PathParam("value") int value) {
        fillWallet(currentUser,-value);
        bet = value;

    }

}


