package block_five.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Deserializer {

    public static Object deserialize(String filename) {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            obj = ois.readObject();
            System.out.println("Объект успешно десериализован: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}