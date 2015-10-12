import com.yevhenio.blackjack.services.CardService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eugene on 12.10.15.
 */
public class TestCards {
    CardService cs = new CardService();

    @Test
    public void cardDeckTest(){
        Assert.assertNotNull(cs.getCards());

    }
    @Test
    public void cardDeckSize(){
        Assert.assertSame(52,cs.getCards().size());
    }
}
