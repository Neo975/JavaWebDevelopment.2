package accountServer;

/**
 * Created by Mike on 24.02.2016.
 */
public interface AccountServerI {
    void addNewUser();
    void removeUser();
    int getUsersLimit();
    void setUsersLimit(int usersLimit);
    int getUsersCount();
}
