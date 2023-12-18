package com.rubnikovich.textcomposite.chain;

import com.rubnikovich.textcomposite.composite.TextComponent;

public class SymbolHandler extends AbstractHandler {

    @Override
    public String handleRequest(TextComponent textComponent, String line) {
        System.out.println("parse lexeme, return symbol");

//        if(textComponent.isLetter)
//        if(textComponent.isPunctuation)

        char a = 97;

        return Character.toString(a);
    }
}
