package com.rubnikovich.textcomposite.main;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.exception.CustomException;
import com.rubnikovich.textcomposite.parser.AbstractParser;
import com.rubnikovich.textcomposite.parser.ParagraphParser;
import com.rubnikovich.textcomposite.reader.CustomReader;
import com.rubnikovich.textcomposite.reader.impl.CustomReaderImpl;

public class Main {
    public static void main(String[] args) throws CustomException {
        CustomReader customReader = new CustomReaderImpl();
        String text = customReader.read("files/text.txt");

        AbstractParser abstractHandler = new ParagraphParser();
        TextComponent textComponent = abstractHandler.parse(text);

        for (int i = 0; i < textComponent.getTextComponent().size(); i++) {
            for (int j = 0; j < textComponent.getTextComponent().get(i).getTextComponent().size(); j++) {
                System.out.println(textComponent.getTextComponent().get(i).getTextComponent().get(j).getTextComponent().size());
                for (int k = 0; k < textComponent.getTextComponent().get(i).getTextComponent().get(j).getTextComponent().size(); k++) {
                    System.out.println(textComponent.getTextComponent().get(i).getTextComponent().get(j).getTextComponent().get(k).collect());
                }
            }
        }
    }
}
