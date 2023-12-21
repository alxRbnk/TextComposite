package com.rubnikovich.textcomposite.main;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.exception.CustomException;
import com.rubnikovich.textcomposite.parser.ParagraphHandler;
import com.rubnikovich.textcomposite.reader.CustomReader;
import com.rubnikovich.textcomposite.reader.impl.CustomReaderImpl;

public class Main {
    public static void main(String[] args) throws CustomException {
        CustomReader customReader = new CustomReaderImpl();
        String text = customReader.read("files/text.txt");
        TextComponent paragraph = new ParagraphHandler().handleRequest(text);
        System.out.println(paragraph.collect());


    }
}
//65-90 A-Z;  97-122 a-z