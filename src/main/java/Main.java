import com.yevhenio.blackjack.ClassCard.Card;
import com.yevhenio.blackjack.ClassCard.CardService;
import com.yevhenio.blackjack.ClassCard.CardsRestService;
import com.yevhenio.blackjack.ClassUser.User;
import com.yevhenio.blackjack.servicePack.UserDAO;
import com.yevhenio.blackjack.servicePack.UserRestService;

import java.util.Random;


/**
 * Created by eugene on 05.10.15.
 */
public class Main {
    public static void main(String[] args) {
        UserRestService us = new UserRestService();
        UserDAO ud = new UserDAO();
        //User le = new User(1111);


        //System.out.println(le.toString());

        CardsRestService csr = new CardsRestService();
        //u.addUser(le);
        CardService cs = new CardService();

        Random r = new Random();
        System.out.println(cs.getCards().get(r.nextInt(52)));
        /*for (int i = 0; i < cs.getCards().size(); i++) {
            Card c = (Card) cs.getCards().get(i);
            System.out.println(c.toString()) ;
        }*/



    }

}
