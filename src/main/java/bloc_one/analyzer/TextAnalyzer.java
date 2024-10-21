package bloc_one.analyzer;

public interface TextAnalyzer {
    Label processText(String text);

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }
}

abstract class KeywordAnalyzer implements TextAnalyzer {

    protected abstract String getKeywords(String text);
    protected abstract Label getLabel(String text);

    @Override
    public Label processText(String text) {
        return getLabel(text);
    }
}

class SpamAnalyzer extends KeywordAnalyzer {

    private String[] keywords;

    protected SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String getKeywords(String text) {
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return keyword;
            }
        }
        return null;
    }

    @Override
    protected Label getLabel(String text) {
        String foundKeyword = getKeywords(text);
        if (foundKeyword != null) {
            return Label.SPAM;
        }
        return Label.OK;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {

    private final String[] NEGATIVE_EMOTICONS = {":(", "=(", ":|"};

    protected NegativeTextAnalyzer() {
    }

    @Override
    protected String getKeywords(String text) {
        for (String emoticon : NEGATIVE_EMOTICONS) {
            if (text.contains(emoticon)) {
                return emoticon;
            }
        }
        return null;
    }

    @Override
    protected Label getLabel(String text) {
        String foundKeyword = getKeywords(text);
        if (foundKeyword != null) {
            return Label.NEGATIVE_TEXT;
        }
        return Label.OK;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;

    protected TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}

class Main {

    public TextAnalyzer.Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            TextAnalyzer.Label result = analyzer.processText(text);
            if (result != TextAnalyzer.Label.OK) {
                return result;
            }
        }
        return TextAnalyzer.Label.OK;
    }

    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        Main testObject = new Main();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }
}