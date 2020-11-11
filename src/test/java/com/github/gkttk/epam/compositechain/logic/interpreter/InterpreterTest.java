package com.github.gkttk.epam.compositechain.logic.interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class InterpreterTest {

    private static final Interpreter INTERPRETER = new Interpreter();

    @ParameterizedTest
    @MethodSource("expressionProvider")
    public void testCalculateShouldReturnCalculatedResultOfGivenExpression(String expression, int expectedValue) {
        //given
        //when
        int result = INTERPRETER.calculateExpression(expression);
        //then
        Assertions.assertEquals(expectedValue, result);
    }


    private static Object[][] expressionProvider() {
        return new Object[][]{
                {"[3 5 10 3 15 * - / +]", 10},
                {"[2 4 8 - +]", 6},
                {"[10 2 4 + *]", 60},
                {"[15 12 22 4 16 10 20 / * / + - -]", 3},
                {"[2 16 *]", 32}
        };
    }

}
