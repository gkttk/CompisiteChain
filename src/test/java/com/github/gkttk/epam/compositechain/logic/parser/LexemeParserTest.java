package com.github.gkttk.epam.compositechain.logic.parser;

import com.github.gkttk.epam.compositechain.model.Component;
import com.github.gkttk.epam.compositechain.model.Leaf;
import com.github.gkttk.epam.compositechain.model.enums.LexemeTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LexemeParserTest {


    private static final AbstractParser LEXEME_PARSER = new LexemeParser(null);
    private static final String TEXT = "It has survived not only [8 3 -] centuries, but also the leap into [10 2 3 - *] electronic typesetting,\n" +
            "remaining [20 2 1 + /] essentially [6 2 3 + *] unchanged";


    @Test
    public void testParseShouldReturnCompositeWithFourExpressionLeafsWhenGivenTextWithFourExpression() {
        //given
        int expectedNumberExpressions = 4;
        //when
        Component parseResult = LEXEME_PARSER.parse(TEXT);
        //then
        long resultNumberExpressions = parseResult
                .getChildes()
                .stream()
                .filter(component -> ((Leaf) component).getType() == LexemeTypes.EXPRESSION)
                .count();
        Assertions.assertEquals(expectedNumberExpressions, resultNumberExpressions);
    }

    @Test
    public void testParseShouldReturnCompositeWithSixteenWordLeafsWhenGivenTextWithSixteenWords() {
        //given
        int expectedNumberWords = 16;
        //when
        Component parseResult = LEXEME_PARSER.parse(TEXT);
        //then
        long resultNumberWords = parseResult
                .getChildes()
                .stream()
                .filter(component -> ((Leaf) component).getType() == LexemeTypes.WORD)
                .count();
        Assertions.assertEquals(expectedNumberWords, resultNumberWords);
    }


}
