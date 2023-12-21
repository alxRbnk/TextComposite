package com.rubnikovich.textcomposite.entity;

public interface TextComponent {

    String collect();

    void addComponent(TextComponent component);

    void removeComponent(TextComponent component);

    int count();

}
