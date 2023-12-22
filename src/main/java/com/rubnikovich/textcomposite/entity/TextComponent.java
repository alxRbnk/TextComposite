package com.rubnikovich.textcomposite.entity;

import java.util.List;

public interface TextComponent {

    String collect();

    void add(TextComponent component);

    void remove(TextComponent component);

    int count();

    List<TextComponent> getTextComponent();

}
