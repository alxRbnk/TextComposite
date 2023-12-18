package com.rubnikovich.textcomposite.chain;

import com.rubnikovich.textcomposite.composite.TextComponent;
import com.rubnikovich.textcomposite.composite.TextComposite;
import com.rubnikovich.textcomposite.composite.TextType;

public class LexemeHandler extends AbstractHandler {
    private AbstractHandler successor = new SymbolHandler();

    @Override
    public String handleRequest(TextComponent textComponent, String line) {
        System.out.println("parse sentence, return lexeme");


        TextComponent lexeme = new TextComposite(TextType.LEXEME);
        String lexemeString = "";
        return successor.handleRequest(lexeme, lexemeString);
    }
}
