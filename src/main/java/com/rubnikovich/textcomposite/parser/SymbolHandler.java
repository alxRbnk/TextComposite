package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextSymbol;
import com.rubnikovich.textcomposite.entity.TextType;

public class SymbolHandler extends AbstractHandler {

    @Override
    public TextComponent handleRequest(String text) {
        TextComponent lexeme = new TextComposite(TextType.LEXEME);
        for (int i = 0; i < text.length(); i++) {
            lexeme.addComponent(new TextSymbol(text.charAt(i)));
        }
        return lexeme;
    }
}
