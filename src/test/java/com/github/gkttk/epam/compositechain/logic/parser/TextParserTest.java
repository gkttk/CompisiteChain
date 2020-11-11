package com.github.gkttk.epam.compositechain.logic.parser;

import com.github.gkttk.epam.compositechain.model.Component;
import com.github.gkttk.epam.compositechain.model.Composite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TextParserTest {


    private static final AbstractParser SUCCESSOR_MOCK = Mockito.mock(SentenceParser.class);
    private static final AbstractParser TEXT_PARSER = new TextParser(SUCCESSOR_MOCK);
    private static final String TEXT = "\tIt has survived not only [8 3 -] centuries, but also the leap into [10 2 * 3 -] electronic typesetting,\n" +
            "remaining [20 2 / 1 +] essentially [6 2 * 3 +] unchanged.\n" +
            "\tIt was popularised in the [12 5 - 4 *] with the release of Letraset sheets containing\n" +
            "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker\n" +
            "including versions of Lorem Ipsum.";


    @Test
    public void testParseShouldReturnCompositeWithTwoChildesWhenGivenTextWithTwoParagraphs() {
        //given
        int expectedNumberChildes = 2;
        when(SUCCESSOR_MOCK.parse(any())).thenReturn(new Composite(new ArrayList<>()));
        //when
        Component parseResult = TEXT_PARSER.parse(TEXT);
        //then
        int resultNumberChildes = parseResult.getChildes().size();
        Assertions.assertEquals(expectedNumberChildes, resultNumberChildes);


    }


}
