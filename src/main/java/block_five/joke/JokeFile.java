package block_five.joke;

public class JokeFile {

    private final String fileName;
    private final String content;

    public JokeFile() {
        this.fileName = "joke.java";
        this.content = "hello world";
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }
}
