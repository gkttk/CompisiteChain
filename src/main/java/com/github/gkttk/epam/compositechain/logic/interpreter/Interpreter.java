package com.github.gkttk.epam.compositechain.logic.interpreter;

import com.github.gkttk.epam.compositechain.logic.interpreter.expressions.*;

import java.util.ArrayList;
import java.util.List;

public class Interpreter {

    private static final String EXPRESSION_SPLIT_REGEX = "[\\[\\s\\]]";

    public int calculateExpression(String expressionString) {
        List<Expression> listExpressions = parseExpression(expressionString);

        Context context = new Context();
        for (Expression expression : listExpressions) {
            expression.interpret(context);
        }

        return context.popValue();
    }


    private List<Expression> parseExpression(String expression) {
        List<Expression> expressions = new ArrayList<>();

        for (String expressionPart : expression.split(EXPRESSION_SPLIT_REGEX)) {
            if (expressionPart.isEmpty()) {
                continue;
            }
            char currentChar = expressionPart.charAt(0);

            switch (currentChar) {
                case '+':
                    expressions.add(new TerminalPlusExpression());
                    break;
                case '-':
                    expressions.add(new TerminalMinusExpression());
                    break;
                case '*':
                    expressions.add(new TerminalMultiplyExpression());
                    break;
                case '/':
                    expressions.add(new TerminalDivideExpression());
                    break;
                default:
                    int numValue = Integer.parseInt(expressionPart);
                    expressions.add(new NonTerminalNumberExpression(numValue));
            }
        }
        return expressions;
    }


}
