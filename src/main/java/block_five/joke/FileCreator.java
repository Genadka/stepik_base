package block_five.joke;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {

    private String absolutePath;

    public FileCreator(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public File createFileJoke() {
        JokeFile jokeFile1 = new JokeFile();
        String fileName = jokeFile1.getFileName();
        String content = jokeFile1.getContent();

        File fileJoke = new File(absolutePath, fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileJoke))) {
            bw.write(content);
            System.out.println("Файл создан: " + fileJoke.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
        return fileJoke;
    }
}
