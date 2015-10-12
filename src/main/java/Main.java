import com.yevhenio.blackjack.services.CardService;
import com.yevhenio.blackjack.rest.CardsRestService;
import com.yevhenio.blackjack.repository.UserDAO;
import com.yevhenio.blackjack.rest.UserRestService;

import java.util.ArrayList;
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


        //u.addUser(le);
        CardService cs = new CardService();

        Random r = new Random();
        System.out.println(cs.getCards().get(r.nextInt(52)));
        /*for (int i = 0; i < cs.getCards().size(); i++) {
            Card c = (Card) cs.getCards().get(i);
            System.out.println(c.toString()) ;
        }*/
        CardsRestService csr = new CardsRestService();
        csr.login(1111);
        csr.start(10);
        System.out.println(csr.show());
        System.out.println("Dealer:" + "\n");
        System.out.println(csr.showDealer());
        System.out.println(us.currentUser);
        System.out.println(us.player);
        csr.getResult();

        ArrayList print = new ArrayList();
        print.add(ud.getTransactions(1111));
        System.out.println(print);

    }


}
