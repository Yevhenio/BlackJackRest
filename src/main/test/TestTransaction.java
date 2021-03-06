import com.yevhenio.blackjack.entity.TransLog;
import com.yevhenio.blackjack.repository.UserDAO;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eugene on 12.10.15.
 */
public class TestTransaction {
    UserDAO ud = new UserDAO();

    @Test
    public void testTransaction() {
        TransLog log = new TransLog();
        log.setId(101);
        log.setValue(50);
        ud.addTrans(log);

    }

    @Test
    public void testTransById() {
        int id = 1111;

        Assert.assertNotNull(ud.getTransactions(id));
    }
}
