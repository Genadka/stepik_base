package block_five.serialize;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class UserListDeserializer {

    public static UserList deserializeUserList(String filename) {
        UserList userList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            userList = (UserList) ois.readObject();
            System.out.println("Список пользователей успешно десериализован.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }
}