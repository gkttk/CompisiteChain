package com.github.gkttk.epam.compositechain.logic.interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContextTest {


    @Test
    public void testPushValueShouldAddNewElementInContext() {
        //given
        Context testContext = new Context();
        int valueForPush = 5;
        int unexpectedSize = testContext.getSize();
        //when
        testContext.pushValue(valueForPush);
        //then
        Assertions.assertNotEquals(unexpectedSize, testContext.getSize());
    }

    @Test
    public void testPopValueShouldRemoveElementFromContext() {
        //given
        Context testContext = new Context();
        testContext.pushValue(5);
        int expectedSize = 0;
        //when
        testContext.popValue();
        //then
        Assertions.assertEquals(expectedSize, testContext.getSize());
    }


}
