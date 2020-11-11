package com.github.gkttk.epam.compositechain.model;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private final List<Component> childes;

    public Composite(List<Component> childes) {
        this.childes = childes;
    }


    @Override
    public List<Component> getChildes() {
        return new ArrayList<>(this.childes);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : this.childes) {
            stringBuilder.append(component.toString());
        }

        return stringBuilder.toString();
    }
}
