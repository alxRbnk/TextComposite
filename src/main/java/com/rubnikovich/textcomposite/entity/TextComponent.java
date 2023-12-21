package com.rubnikovich.textcomposite.entity;

public interface TextComponent {

    String collect();

    void add(TextComponent component);

    void remove(TextComponent component);

    int count();

}
