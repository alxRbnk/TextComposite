package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler extends AbstractHandler {
    private static final String REGEX = " {1,4}\\S+\\.?";  //fixme
    private AbstractHandler successor = new SymbolHandler();

    @Override
    public TextComponent handleRequest(String text) {
        TextComponent sentence = new TextComposite(TextType.SENTENCE);
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            sentence.add(successor.handleRequest(matcher.group()));
        }
        return sentence;
    }
}
