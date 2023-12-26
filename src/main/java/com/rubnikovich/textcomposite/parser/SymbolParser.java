package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextSymbol;
import com.rubnikovich.textcomposite.entity.TextType;

public class SymbolParser extends AbstractParser {

    @Override
    public TextComponent parse(String text) {
        TextComponent lexeme = new TextComposite(TextType.LEXEME);
        for (int i = 0; i < text.length(); i++) {
            TextComponent symbol = new TextSymbol(text.charAt(i));
            lexeme.add(symbol);
        }
        return lexeme;
    }

    @Override
    public TextComponent handleRequest(String text) {
        AbstractParser.textDeep = 0;
        TextComponent lexeme = new TextComposite(TextType.LEXEME);
        for (int i = 0; i < text.length(); i++) {
            TextComponent symbol = new TextSymbol(text.charAt(i));
            lexeme.add(symbol);
        }
        return lexeme;
    }

}
