package block_five.serialize;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;;

public class UserListSerializer {

    public static void serializeUserList(UserList userList, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(userList);
            System.out.println("Список пользователей успешно сериализован.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
