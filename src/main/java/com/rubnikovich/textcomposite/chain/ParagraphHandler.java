package com.rubnikovich.textcomposite.chain;

import com.rubnikovich.textcomposite.composite.TextComponent;
import com.rubnikovich.textcomposite.composite.TextComposite;
import com.rubnikovich.textcomposite.composite.TextType;

public class ParagraphHandler extends AbstractHandler {
    private AbstractHandler successor = new SentenceHandler();

    @Override
    public String handleRequest(TextComponent textComponent, String line) {
        System.out.println("parse text, return paragraph");

        TextComponent paragraph = new TextComposite(TextType.PARAGRAPH);

        String paragraphString = "";
        return successor.handleRequest(paragraph, paragraphString);
    }
}
