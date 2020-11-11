package com.github.gkttk.epam.compositechain.logic.parser;

import com.github.gkttk.epam.compositechain.model.Component;
import com.github.gkttk.epam.compositechain.model.Leaf;

public class LexemeParser extends AbstractParser {


    private final static String LEXEME_REGEX = "\\[(\\d+\\s)+([\\*\\-\\+\\/]\\s?)+\\]|\\b\\w+[,.!?]?(\\n)*|[.!?](\\n)*";
    private final static String EXPRESSION_BEGIN = "[";
    private final static String EXPRESSION_END = "]";

    public LexemeParser(AbstractParser successor) {
        super(successor);
    }

    @Override
    protected Component createComponent(String text) {
        Leaf leaf = null;
        if (text.startsWith(EXPRESSION_BEGIN) && text.endsWith(EXPRESSION_END)) {
            leaf = Leaf.createExpressionLeaf(text);
        } else {
            leaf = Leaf.createWordLeaf(text);

        }
        return leaf;
    }

    @Override
    protected String getRegex() {
        return LEXEME_REGEX;
    }


}
