package com.github.gkttk.epam.compositechain.logic.interpreter.expressions;

import com.github.gkttk.epam.compositechain.logic.interpreter.Context;
import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ExpressionsTest {

    private Context context;

    @BeforeEach
    void initContext() {
        this.context = new Context();
        this.context.pushValue(5);
        this.context.pushValue(15);
    }

    @ParameterizedTest
    @MethodSource("expressionProvider")
    public void testExpression(Expression expression, int expectedResult) {
        //given
        //when
        expression.interpret(this.context);
        //then
        Integer result = context.popValue();
        Assertions.assertEquals(expectedResult, result);
    }


    @DataProvider
    public static Object[][] expressionProvider() {
        return new Object[][]{
                {new NonTerminalNumberExpression(100), 100},
                {new TerminalDivideExpression(), 3},
                {new TerminalMinusExpression(), 10},
                {new TerminalMultiplyExpression(), 75},
                {new TerminalPlusExpression(), 20},
        };
    }

}
