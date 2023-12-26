package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    private AbstractParser successor = new LexemeParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent paragraph = new TextComposite(TextType.PARAGRAPH);
        Pattern pattern = Pattern.compile(TextType.PARAGRAPH.getRegex());
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String substring = matcher.group();
            TextComponent textComponent = successor.parse(substring);
            paragraph.add(textComponent);
        }
        return paragraph;
    }
}
