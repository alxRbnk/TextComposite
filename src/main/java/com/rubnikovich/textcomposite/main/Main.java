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
        System.out.println(textComponent.collect());
        System.out.println(textComponent.count());

        System.out.println("------------------");

        AbstractParser abstractHandler1 = new ParagraphParser();
        TextComponent textComponent1 = abstractHandler1.parse(text);

    }
}
