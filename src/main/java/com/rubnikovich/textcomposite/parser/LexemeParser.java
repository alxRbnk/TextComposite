package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private AbstractParser successor = new SymbolParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent sentence = new TextComposite(TextType.SENTENCE);
        Pattern pattern = Pattern.compile(TextType.SENTENCE.getRegex());
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String substring = matcher.group();
            TextComponent textComponent = successor.parse(substring);
            sentence.add(textComponent);
        }
        return sentence;
    }
}
