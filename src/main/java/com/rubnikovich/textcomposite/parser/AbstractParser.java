package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser {
    private static int deep = 0;

    public TextComponent parse(String allText) {
        AbstractParser abstractParser = TextType.values()[deep].getSuccessor();
        TextComponent text = new TextComposite(TextType.values()[deep]);
        Pattern pattern = Pattern.compile(TextType.values()[deep].getRegex());
        Matcher matcher = pattern.matcher(allText);
        while (matcher.find()) {
            deep++;
            String substring = matcher.group();
            TextComponent textComponent = abstractParser.parse(substring);
            text.add(textComponent);
            deep--;
        }
        return text;
    }

}
