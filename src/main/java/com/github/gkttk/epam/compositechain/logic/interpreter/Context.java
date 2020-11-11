package com.github.gkttk.epam.compositechain.logic.interpreter;

import java.util.ArrayDeque;

public class Context {

    private final ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer popValue() {
        return this.contextValues.pop();
    }

    public void pushValue(Integer value) {
        this.contextValues.push(value);
    }

    //default access for test
    int getSize() {
        return this.contextValues.size();
    }

}
