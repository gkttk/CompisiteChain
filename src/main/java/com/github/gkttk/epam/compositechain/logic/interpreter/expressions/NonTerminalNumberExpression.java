package com.github.gkttk.epam.compositechain.logic.interpreter.expressions;

import com.github.gkttk.epam.compositechain.logic.interpreter.Context;

public class NonTerminalNumberExpression implements Expression {

    private final int number;

    public NonTerminalNumberExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
