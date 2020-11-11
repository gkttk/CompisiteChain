package com.github.gkttk.epam.compositechain.logic.interpreter.expressions;

import com.github.gkttk.epam.compositechain.logic.interpreter.Context;

public class TerminalMinusExpression implements Expression {

    @Override
    public void interpret(Context context) {
        Integer firstValue = context.popValue();
        Integer secondValue = context.popValue();
        Integer resultValue = firstValue - secondValue;
        context.pushValue(resultValue);
    }
}
