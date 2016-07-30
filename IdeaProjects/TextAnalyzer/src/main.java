import Label.Label;
import TextAnalyzer.TextAnalyzer;

public class main {


    static abstract  class KeywordAnalyzer implements  TextAnalyzer {

            protected abstract String[] getKeywords();
            protected abstract Label getLabel();

        @Override
        public Label processText(String text) {

            for (String keyword : getKeywords())
                if (text.contains(keyword))
                    return getLabel();

            return Label.OK;
        }
    }

///////////////////////////////////////////////////////////////////////////////////////

    static class NegativeTextAnalyzer extends KeywordAnalyzer {

        private String[] keywords = new String[]{":|", ":(", "=("};

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

///////////////////////////////////////////////////////////////////////////////////////

    static class SpamAnalyzer extends KeywordAnalyzer {

        private String[] keywords;

        public SpamAnalyzer( String... keywords) {
            this.keywords = new String[keywords.length];
            this.keywords = keywords.clone();
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

///////////////////////////////////////////////////////////////////////////////////////

    static class TooLongTextAnalyzer implements TextAnalyzer {

        private int maxLength;

        public TooLongTextAnalyzer(int maxLength){
            this.maxLength = maxLength;
        }

        @Override
         public Label processText(String text) {
            if (text.length() > maxLength)
                return Label.TOO_LONG;
            else
                return Label.OK;
        }
    }

///////////////////////////////////////////////////////////////////////////////////////

    static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer texan : analyzers)
        if (texan.processText(text) != Label.OK)
            return texan.processText(text);
        return  Label.OK;
    }

///////////////////////////////////////////////////////////////////////////////////////



    public static void main(String[] args) {

        TextAnalyzer[] analyzers = new TextAnalyzer[]{new TooLongTextAnalyzer(20),
                                                    new SpamAnalyzer("first","second"),
                                                    new NegativeTextAnalyzer()};

        System.out.println(checkLabels(analyzers,"this is  test"));


    }
}
