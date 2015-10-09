import com.yevhenio.blackjack.ClassCard.CardService;
import com.yevhenio.blackjack.ClassUser.User;
import com.yevhenio.blackjack.servicePack.UserDAO;
import com.yevhenio.blackjack.servicePack.UserService;

import java.util.Random;


/**
 * Created by eugene on 05.10.15.
 */
public class Main {
    public static void main(String[] args) {
        //UserService us = new UserService();
        //UserDAO ud = new UserDAO();
        //User le = new User(1111);


        //System.out.println(le.toString());

        //us.fillWallet(ud.getFromBase(1111), -50);
        //u.addUser(le);
        CardService cs = new CardService();

        Random r = new Random();
        System.out.println(cs.getCards().get(r.nextInt(52)));


    }

}
