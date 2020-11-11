package com.github.gkttk.epam.compositechain.model;

import com.github.gkttk.epam.compositechain.model.enums.LexemeTypes;

import java.util.Collections;
import java.util.List;

public class Leaf implements Component {

    private final String value;
    private final LexemeTypes type;

    private Leaf(String value, LexemeTypes type) {
        this.value = value;
        this.type = type;
    }

    public static Leaf createWordLeaf(String value) {
        return new Leaf(value, LexemeTypes.WORD);
    }

    public static Leaf createExpressionLeaf(String value) {
        return new Leaf(value, LexemeTypes.EXPRESSION);
    }


    public String getValue() {
        return value;
    }

    public LexemeTypes getType() {
        return type;
    }

    @Override
    public List<Component> getChildes() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return value + " ";
    }
}
