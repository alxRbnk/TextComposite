package com.rubnikovich.textcomposite.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private TextType type;
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite(TextType type){
        this.type = type;
    }

    @Override
    public String collect() {
        StringBuilder text = new StringBuilder();
        for(TextComponent component: components){
            text.append(component.collect());
        }
//        components.forEach(component -> text.append(component.collect()));
//        components.stream().forEach(component->text.append(component.collect()));
        return text.toString();
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public int count() {
        return components.stream()
                .mapToInt(TextComponent::count)
                .sum();
    }

    @Override
    public List<TextComponent> getTextComponent(){
        return components;
    }
}