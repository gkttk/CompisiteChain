package com.github.gkttk.epam.compositechain.logic.calculator;

import com.github.gkttk.epam.compositechain.logic.interpreter.Interpreter;
import com.github.gkttk.epam.compositechain.model.Component;
import com.github.gkttk.epam.compositechain.model.Composite;
import com.github.gkttk.epam.compositechain.model.Leaf;
import com.github.gkttk.epam.compositechain.model.enums.LexemeTypes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeProcessor {

    private final static int ROOT_TREE_LEVEL = 0;
    private final static int PARAGRAPH_TREE_LEVEL = 1;
    private final static int LEXEME_TREE_LEVEL = 3;

    private final Interpreter interpreter = new Interpreter();

    public Component sortParagraphBySentences(Component sortingComponent) {
        Comparator<Component> paragraphComparator = Comparator.comparingInt(paragraph -> paragraph.getChildes().size());

        return walkTree(sortingComponent, ROOT_TREE_LEVEL, PARAGRAPH_TREE_LEVEL, paragraphComparator);

    }

    public Component sortSentencesByLexemeLength(Component sortingComponent) {
        Comparator<Component> lexemeComparator = ((firstLexeme, secondLexeme) -> {
            String fLexemeValue = ((Leaf) firstLexeme).getValue();
            String sLexemeValue = ((Leaf) secondLexeme).getValue();

            return fLexemeValue.length() - sLexemeValue.length();
        });

        return walkTree(sortingComponent, ROOT_TREE_LEVEL, LEXEME_TREE_LEVEL, lexemeComparator);

    }

    public Component calculateExpressionLeafs(Component component) {
        List<Component> childes = component.getChildes();
        List<Component> newChildes = new ArrayList<>();
        if (childes.size() > 0) {
            for (Component child : childes) {
                Component calculated = calculateExpressionLeafs(child);
                newChildes.add(calculated);
            }
        } else {
            Leaf newLeaf = createNewLeaf(component);
            newChildes.add(newLeaf);
        }
        return new Composite(newChildes);
    }


    private Component walkTree(Component component, int currentDepth, int desiredDepth, Comparator<Component> comparator) {
        List<Component> currentChildes = component.getChildes();
        List<Component> newChildes = new ArrayList<>();
        currentDepth++;
        if (currentDepth < desiredDepth) {
            for (Component child : currentChildes) {
                Component newComponent = walkTree(child, currentDepth, desiredDepth, comparator);//recursive call
                newChildes.add(newComponent);
            }
        } else {
            List<Component> sortedComponentChildes = sortComponentChildes(currentChildes, comparator);
            newChildes.addAll(sortedComponentChildes);
            return new Composite(newChildes);
        }

        return new Composite(newChildes);
    }

    private List<Component> sortComponentChildes(List<Component> componentChildes, Comparator<Component> comparator) {
        return componentChildes.stream().sorted(comparator).collect(Collectors.toList());
    }


    private Leaf createNewLeaf(Component component) {
        Leaf result = null;
        LexemeTypes type = ((Leaf) component).getType();
        String value = ((Leaf) component).getValue();

        if (type == LexemeTypes.WORD) {
            result = Leaf.createWordLeaf(value);
        } else {
            Integer calculate = interpreter.calculateExpression(value);
            result = Leaf.createExpressionLeaf(calculate.toString());
        }

        return result;

    }


}
