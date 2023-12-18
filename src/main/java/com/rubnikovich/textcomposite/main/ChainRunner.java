package com.rubnikovich.textcomposite.main;

import com.rubnikovich.textcomposite.composite.Letter;
import com.rubnikovich.textcomposite.composite.TextComponent;
import com.rubnikovich.textcomposite.composite.TextComposite;
import com.rubnikovich.textcomposite.composite.TextType;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ChainRunner {
    public static void main(String[] args) {
        String customText = "   Hello Bob. Hello.    Goodbye Bob. Goodbye. ";

        String[] arraySymbol = customText.split("");
        String[] arrayLexeme = customText.split("    ");


        TextComponent lexeme = new TextComposite(TextType.LEXEME);
        for (int i = 0; i < customText.length(); i++) {
            TextComponent symbolComponent = new Letter(arraySymbol[i].charAt(0));
            lexeme.addComponent(symbolComponent);
        }

        System.out.println(lexeme.collect());




    }
}
