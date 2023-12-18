package com.rubnikovich.textcomposite.chain;

import com.rubnikovich.textcomposite.composite.TextComponent;
import com.rubnikovich.textcomposite.composite.TextComposite;
import com.rubnikovich.textcomposite.composite.TextType;

public class SentenceHandler extends AbstractHandler {
    private AbstractHandler successor = new LexemeHandler();

    @Override
    public String handleRequest(TextComponent textComponent, String line) {
        System.out.println("parse paragraph, return sentence");

        TextComponent sentence = new TextComposite(TextType.SENTENCE);
        String sentenceString = "";
        return successor.handleRequest(sentence, sentenceString);
    }
}
