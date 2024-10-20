package block_five.joke;

public class MainJoke {
    public static void main(String[] args) {
        FileCreator jokeCreator = new FileCreator("C:\\my_projeject\\stepik_base\\src\\main\\java\\bloc_one");
        jokeCreator.createFileJoke();

        RecursiveFileCreator recursiveFileCreator = new RecursiveFileCreator("C:\\my_projeject\\stepik_base\\test", new FileCreator("C:\\my_projeject\\stepik_base\\test"));
    }
}


