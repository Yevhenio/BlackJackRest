import com.yevhenio.blackjack.rest.CardsRestService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eugene on 12.10.15.
 */
public class TestGameRest {
    CardsRestService csr = new CardsRestService();

    @Test
    public void loginTest(){
        csr.login(1111);
    }


}
