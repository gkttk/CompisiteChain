package com.github.gkttk.epam.compositechain.logic.parser.chaincreator;

import com.github.gkttk.epam.compositechain.logic.parser.AbstractParser;
import com.github.gkttk.epam.compositechain.logic.parser.LexemeParser;
import com.github.gkttk.epam.compositechain.logic.parser.SentenceParser;
import com.github.gkttk.epam.compositechain.logic.parser.TextParser;

public class ParserChainCreator {

    public AbstractParser build() {
        AbstractParser lexemeParser = new LexemeParser(null);
        AbstractParser sentenceParser = new SentenceParser(lexemeParser);
        return new TextParser(sentenceParser);


    }

}
