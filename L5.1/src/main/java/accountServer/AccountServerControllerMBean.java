package accountServer;

/**
 * Created by Mike on 24.02.2016.
 */
public interface AccountServerControllerMBean {
    public int getUsers();
    public int getUsersLimit();
    public void setUsersLimit(int usersLimit);
}
