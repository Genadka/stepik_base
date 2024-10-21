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

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void createFileJoke(String absolutePath) {
        JokeFile jokeFile = new JokeFile();
        String fileName = jokeFile.getFileName();
        String content = jokeFile.getContent();

        File fileJoke = new File(absolutePath, fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileJoke))) {
            bw.write(content);
            System.out.println("Файл создан: " + fileJoke.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }

        if (absolutePath == null) {
            return;
        }
        File parentDir = fileJoke.getParentFile();
        if (parentDir != null && parentDir.getParent() != null) {
            createFileJoke(parentDir.toString());
        }
    }
}

