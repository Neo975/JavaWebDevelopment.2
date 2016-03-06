package accountServer;

/**
 * Created by Mike on 24.02.2016.
 */
public interface AccountServerControllerMBean {
    int getUsers();
    int getUsersLimit();
    void setUsersLimit(int usersLimit);
}
