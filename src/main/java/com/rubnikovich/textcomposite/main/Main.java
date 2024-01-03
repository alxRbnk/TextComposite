package com.rubnikovich.textcomposite.main;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.exception.CustomException;
import com.rubnikovich.textcomposite.parser.AbstractParser;
import com.rubnikovich.textcomposite.parser.ParagraphParser;
import com.rubnikovich.textcomposite.reader.CustomReader;
import com.rubnikovich.textcomposite.reader.impl.CustomReaderImpl;
import com.rubnikovich.textcomposite.service.CustomService;
import com.rubnikovich.textcomposite.service.impl.CustomServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws CustomException {
        CustomReader customReader = new CustomReaderImpl();
        String text = customReader.read("files/text.txt");

        AbstractParser abstractHandler = new ParagraphParser();
        TextComponent textComponent = abstractHandler.parse(text);

        CustomService service = CustomServiceImpl.getInstance();
        logger.info(service.getSentenceWithBiggestLexeme(textComponent).collect());
        logger.info(service.getCountVowelConsonant(textComponent));
        logger.info(service.getRepetitiveWords(textComponent));
    }
}
