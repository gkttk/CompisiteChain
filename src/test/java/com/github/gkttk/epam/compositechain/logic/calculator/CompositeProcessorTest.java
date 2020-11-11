package com.github.gkttk.epam.compositechain.logic.calculator;

import com.github.gkttk.epam.compositechain.model.Component;
import com.github.gkttk.epam.compositechain.model.Composite;
import com.github.gkttk.epam.compositechain.model.Leaf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompositeProcessorTest {

    private static final CompositeProcessor COMPOSITE_PROCESSOR = new CompositeProcessor();
    private static final Component TEXT_COMPONENT = getTextComponent();

    @Test
    public void testSortSentencesByLexemeLengthShouldReturnNewCompositeWithSortedSentencesByLexemesLengthWhenGetUnsortedComposite() {
        //given
        String expectedText = "Hello, world! bye. Expression [3 5 10 3 15 * - / +] hey! Second expression [2 4 8 - *] ";
        //when
        Component sortedComponent = COMPOSITE_PROCESSOR.sortSentencesByLexemeLength(TEXT_COMPONENT);
        //then
        Assertions.assertEquals(expectedText, sortedComponent.toString());
    }

    @Test
    public void testSortParagraphsBySentencesShouldReturnNewCompositeWithSortedParagraphsBySentencesCountWhenGetUnsortedComposite() {
        //given
        String expectedText = "Second expression [2 4 8 - *] hey! Hello, world! Expression [3 5 10 3 15 * - / +] bye. ";
        //when
        Component sortedComponent = COMPOSITE_PROCESSOR.sortParagraphBySentences(TEXT_COMPONENT);
        //then
        Assertions.assertEquals(expectedText, sortedComponent.toString());
    }

    @Test
    public void testCalculateExpressionLeafsShouldReturnNewCompositeWithCalculatedExpressions() {
        //given
        String expectedText = "Hello, world! Expression 10 bye. Second expression 8 hey! ";
        //when
        Component calculatedComponent = COMPOSITE_PROCESSOR.calculateExpressionLeafs(TEXT_COMPONENT);
        //then
        Assertions.assertEquals(expectedText, calculatedComponent.toString());
    }


    private static Component getTextComponent() {

        List<Component> firstWords = Arrays.asList(
                Leaf.createWordLeaf("Hello,"),
                Leaf.createWordLeaf("world!")
        );

        Component sentence1 = new Composite(firstWords);

        List<Component> secondWords = Arrays.asList(
                Leaf.createWordLeaf("Expression"),
                Leaf.createExpressionLeaf("[3 5 10 3 15 * - / +]"),
                Leaf.createWordLeaf("bye.")
        );

        Component sentence2 = new Composite(secondWords);

        List<Component> thirdWords = Arrays.asList(
                Leaf.createWordLeaf("Second"),
                Leaf.createWordLeaf("expression"),
                Leaf.createExpressionLeaf("[2 4 8 - *]"),
                Leaf.createWordLeaf("hey!")
        );

        Component sentence3 = new Composite(thirdWords);


        List<Component> firstSentences = Arrays.asList(sentence1, sentence2);
        List<Component> secondSentences = Collections.singletonList(sentence3);

        Component paragraph1 = new Composite(firstSentences);
        Component paragraph2 = new Composite(secondSentences);

        List<Component> paragraphsList = Arrays.asList(paragraph1, paragraph2);

        return new Composite(paragraphsList);

    }

}
