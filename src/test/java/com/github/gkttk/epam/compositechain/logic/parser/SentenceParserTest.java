package com.github.gkttk.epam.compositechain.logic.parser;

import com.github.gkttk.epam.compositechain.model.Component;
import com.github.gkttk.epam.compositechain.model.Composite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class SentenceParserTest {


    private static final AbstractParser SUCCESSOR_MOCK = Mockito.mock(LexemeParser.class);
    private static final AbstractParser SENTENCE_PARSER = new SentenceParser(SUCCESSOR_MOCK);
    private static final String TEXT = "It has survived not only [8 3 -] centuries, but also the leap into [10 2 * 3 -] electronic typesetting,\n" +
            "remaining [20 2 / 1 +] essentially [6 2 * 3 +] unchanged. Hello, world! How are you? Bye.";


    @Test
    public void testParseShouldReturnCompositeWithFourChildesWhenGivenTextWithFourSentences() {
        //given
        int expectedNumberChildes = 4;
        when(SUCCESSOR_MOCK.parse(any())).thenReturn(new Composite(new ArrayList<>()));
        //when
        Component parseResult = SENTENCE_PARSER.parse(TEXT);
        //then
        int resultNumberChildes = parseResult.getChildes().size();
        Assertions.assertEquals(expectedNumberChildes, resultNumberChildes);


    }


}
