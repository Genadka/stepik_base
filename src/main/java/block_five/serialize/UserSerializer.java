package block_five.serialize;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class UserSerializer {

    public static void serializeUser(User user, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(user);
            System.out.println("Пользователь успешно сериализован.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
