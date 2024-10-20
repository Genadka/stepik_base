package block_five.joke;

import java.io.File;
import java.util.List;

public class RecursiveFileCreator {

    private String absolutePaths;
    private FileCreator jokeFiles;

    public RecursiveFileCreator(String absolutePaths, FileCreator jokeFiles) {
        this.absolutePaths = absolutePaths;
        this.jokeFiles = jokeFiles;
    }

    public RecursiveFileCreator() {
    }

    public FileCreator getJokeFiles() {
        return jokeFiles;
    }

    public String getAbsolutePaths() {
        return absolutePaths;
    }

    public void createFileJokes() {
        jokeFiles.createFileJoke();
        AllPaths allPaths = new AllPaths(absolutePaths);
        List<File> subDirectories = allPaths.getAllPaths();

        for (File subDirectory : subDirectories) {
            RecursiveFileCreator recursiveFileCreator = new RecursiveFileCreator(subDirectory.getAbsolutePath(), jokeFiles);
            recursiveFileCreator.createFileJokes();
        }
    }
}
