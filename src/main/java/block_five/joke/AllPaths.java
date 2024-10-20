package block_five.joke;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllPaths {

    private String absolutePaths;

    public AllPaths(String absolutePaths) {
        this.absolutePaths = absolutePaths;
    }

    public AllPaths(){
    }

    public String getAbsolutePaths() {
        return absolutePaths;
    }

    public List<File> getAllPaths() {
        File directory = new File(absolutePaths);
        File[] arrDirectory = directory.listFiles();

        if (arrDirectory == null) {
            throw new IllegalArgumentException("Каталог пуст или недоступен.");
        }

        List<File> allDirectories = new ArrayList<>();
        for (File file : arrDirectory) {
            if (file.isDirectory()) {
                allDirectories.add(file);
            }
        }

        return allDirectories;
    }
}
