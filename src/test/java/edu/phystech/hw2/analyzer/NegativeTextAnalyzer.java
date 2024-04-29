package edu.phystech.hw2.analyzer;


import java.util.List;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final List<String> NEGATIVE_SMILES = List.of(":(", "=(", ":|");

    public NegativeTextAnalyzer() {
        super(NEGATIVE_SMILES, Label.NEGATIVE);
    }

    @Override
    public Label processText(String text) {
        for (String word : this.getKeywords()) {
            if (text.indexOf(word) == text.length() - word.length()) {
                return Label.NEGATIVE;
            }
        }
        return Label.OK;
    }
}
