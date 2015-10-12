import com.yevhenio.blackjack.entity.User;
import com.yevhenio.blackjack.repository.UserDAO;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eugene on 12.10.15.
 */
public class TestUserDB {
    UserDAO ud = new UserDAO();

    @Test
    public void testAdding() {

        User user = new User();
        user.setId(101);
        user.setWallet(100);

        ud.addUser(user);
    }

    @Test
    public void getFromDB() {
        Assert.assertNotNull(ud.getFromBase(101010));
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(101010);
        user.setWallet(250);
        ud.updateUser(user);
    }
}
