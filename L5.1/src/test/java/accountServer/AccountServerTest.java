package accountServer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mike on 25.02.2016.
 */
public class AccountServerTest {
    private AccountServerI accountServer;

    private void init() {
        accountServer = new AccountServer(10);
    }

    @Test
    public void testAccountServer() {
        init();
        accountServer.setUsersLimit(89);
        assertEquals(89, accountServer.getUsersLimit());
    }
}
