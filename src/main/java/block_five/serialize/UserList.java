package block_five.serialize;

import java.io.Serial;
import java.io.Serializable;

public class UserList implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private User[] users;

    public UserList(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }
}
