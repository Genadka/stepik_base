package block_five.serialize;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class UserDeserializer {

    public static User deserializeUser(String filename) {
        User user = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            user = (User) ois.readObject();
            System.out.println("Пользователь успешно десериализован.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}