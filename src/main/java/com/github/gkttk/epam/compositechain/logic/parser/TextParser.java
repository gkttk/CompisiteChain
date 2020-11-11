package com.github.gkttk.epam.compositechain.logic.parser;


public class TextParser extends AbstractParser {

    private final static String PARAGRAPH_REGEX = "(\\t|\\s{4})(.|\\n)*?(\\Z|\\n(?=\\s{4}|\\t))";

    public TextParser(AbstractParser successor) {
        super(successor);
    }

    @Override
    protected String getRegex() {
        return PARAGRAPH_REGEX;
    }


}
