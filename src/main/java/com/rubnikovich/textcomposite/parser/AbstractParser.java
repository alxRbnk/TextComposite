package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser {
    public static int textDeep = 0;

    public abstract TextComponent parse(String text);

    public TextComponent handleRequest(String allText) {
        TextComponent text = new TextComposite(TextType.values()[textDeep]);
        Pattern pattern = Pattern.compile(TextType.values()[textDeep].getRegex());
        Matcher matcher = pattern.matcher(allText);
        while (matcher.find()) {
            textDeep++;
            String substring = matcher.group();
            AbstractParser abstractParser = TextType.values()[textDeep].getSuccessor();
            TextComponent textComponent = abstractParser.handleRequest(substring);
            text.add(textComponent);
        }
        return text;
    }
}
