package com.github.gkttk.epam.compositechain.logic.parser;

public class SentenceParser extends AbstractParser {

    private final static String SENTENCE_REGEX = ".*?[\\.\\?!](\\n)*";

    public SentenceParser(AbstractParser successor) {
        super(successor);
    }

    @Override
    protected String getRegex() {
        return SENTENCE_REGEX;
    }


}
