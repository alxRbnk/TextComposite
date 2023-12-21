package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler extends AbstractHandler {
    private static final String REGEX = " {4}.+?\\. .+?\\."; //fixme
    private AbstractHandler successor = new SentenceHandler();

    @Override
    public TextComponent handleRequest(String text) {
        TextComponent textComponent = new TextComposite(TextType.TEXT);
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            textComponent.addComponent(successor.handleRequest(matcher.group()));
        }
        return textComponent;
    }
}
