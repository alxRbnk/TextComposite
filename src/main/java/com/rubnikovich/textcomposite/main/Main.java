package com.rubnikovich.textcomposite.main;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.exception.CustomException;
import com.rubnikovich.textcomposite.parser.AbstractParser;
import com.rubnikovich.textcomposite.parser.ParagraphParser;
import com.rubnikovich.textcomposite.reader.CustomReader;
import com.rubnikovich.textcomposite.reader.impl.CustomReaderImpl;
import com.rubnikovich.textcomposite.service.CustomService;
import com.rubnikovich.textcomposite.service.Impl.CustomServiceImpl;

public class Main {
    public static void main(String[] args) throws CustomException {
        CustomReader customReader = new CustomReaderImpl();
        String text = customReader.read("files/text.txt");

        AbstractParser abstractHandler = new ParagraphParser();
        TextComponent textComponent = abstractHandler.handleRequest(text);

        CustomService customService = CustomServiceImpl.getInstance();
        System.out.println(customService.getRepetitiveWords(textComponent));
        System.out.println(customService.getCountVowelConsonant(textComponent));


    }
}
