package block_five.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {

    public static void serialize(Object obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            System.out.println("Объект успешно сериализован: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}