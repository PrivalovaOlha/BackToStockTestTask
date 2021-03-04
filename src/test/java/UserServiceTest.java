import com.example.db.Stock;
import com.example.entity.Product;
import com.example.entity.ProductCategory;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Stock.class)
public class UserServiceTest {

    @Mock
    private Stock stock;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void subscribeSuccessCase() {
        User ivan = new User(1L, "ivan", true, 25);
        Product antibiotic = new Product("1", ProductCategory.MEDICAL, "antibiotic");

        assertTrue(userService.subscribe(ivan, antibiotic));
    }

    @Test(expected = NullPointerException.class)
    public void subscribeWhenUserIsNull() {
        Product antibiotic = new Product("1", ProductCategory.MEDICAL, "antibiotic");

        userService.subscribe(null, antibiotic);
    }

    @Test(expected = NullPointerException.class)
    public void subscribeWhenProductIsNull() {
        User ivan = new User(1L, "ivan", true, 25);

        userService.subscribe(ivan, null);
    }

    @Test
    public void subscribeWhenAddingDuplicate() {
        User ivan = new User(1L, "ivan", true, 25);
        Product antibiotic = new Product("1", ProductCategory.MEDICAL, "antibiotic");

        assertTrue(userService.subscribe(ivan, antibiotic));
        assertFalse(userService.subscribe(ivan, antibiotic));
    }

 /*   @Test
    public void subscribedUsersSuccessCase() {
        Product antibiotic = new Product("1", ProductCategory.MEDICAL, "antibiotic");

        User ivan = new User(4L, "Ivan Ivanov", false, 25);
        ivan.addToWantedProducts(antibiotic);

        User karl = new User(3L, "Karl Karlov", false, 12);
        karl.addToWantedProducts(antibiotic);


        PowerMockito.mockStatic(Stock.class);
        PowerMockito.when(Stock.users).thenReturn(Set.of(ivan, karl));
        PowerMockito.when(Stock.getInstance().getUsers()).thenReturn(Set.of(ivan, karl));
        Mockito.when(stock.getUsers()).thenReturn(Set.of(ivan, karl));
        assertEquals(2, userService.subscribedUsers(antibiotic).size());
    }*/

    @Test(expected = NullPointerException.class)
    public void subscribedUsersWhenProductIsNull() {
        userService.subscribedUsers(null);
    }
}

