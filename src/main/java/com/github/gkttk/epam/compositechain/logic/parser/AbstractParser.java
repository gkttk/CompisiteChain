package com.github.gkttk.epam.compositechain.logic.parser;

import com.github.gkttk.epam.compositechain.model.Component;
import com.github.gkttk.epam.compositechain.model.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser {

    private final AbstractParser successor;

    public AbstractParser(AbstractParser successor) {
        this.successor = successor;
    }

    public Component parse(String text) {

        String regex = getRegex();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<Component> childList = new ArrayList<>();
        while (matcher.find()) {
            String textPart = matcher.group();
            Component child = createComponent(textPart);
            childList.add(child);
        }
        return new Composite(childList);
    }

    protected Component createComponent(String text) {
        return getSuccessor().parse(text);//recursive call
    }

    protected abstract String getRegex();

    protected AbstractParser getSuccessor() {
        return this.successor;
    }


}
