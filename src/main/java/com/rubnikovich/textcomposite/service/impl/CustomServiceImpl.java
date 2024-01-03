package com.rubnikovich.textcomposite.service.impl;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextType;
import com.rubnikovich.textcomposite.service.CustomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomServiceImpl implements CustomService {
    private static Logger logger = LogManager.getLogger();
    private static CustomServiceImpl instance = new CustomServiceImpl();

    private CustomServiceImpl() {
    }

    public static CustomServiceImpl getInstance() {
        return instance;
    }

    public void sortParagraph(TextComponent textComponent) {
        textComponent.getTextComponent().sort((o1, o2) -> o1.getTextComponent().size() - o2.getTextComponent().size());
    }

    public TextComponent getSentenceWithBiggestLexeme(TextComponent textComponent) {
        TextComponent sentence = null;
        TextComponent lexeme = null;
        int max = Integer.MIN_VALUE;
        for (TextComponent componentParagraph : textComponent.getTextComponent()) {
            for (TextComponent componentSentence : componentParagraph.getTextComponent()) {
                for (TextComponent componentLexeme : componentSentence.getTextComponent()) {
                    int currentSize = componentLexeme.getTextComponent().size();
                    if (currentSize > max) {
                        max = currentSize;
                        sentence = componentSentence;
                        lexeme = componentLexeme;
                    }
                }
            }
        }
//        logger.info(lexeme.collect());
        return sentence;
    }

    public void removeSentenceShorterThan(TextComponent textComponent, int countLexeme) {
        for (TextComponent paragraph : textComponent.getTextComponent()) {
            paragraph.getTextComponent().removeIf(sentence -> sentence.getTextComponent().size() < countLexeme);
        }
    }

    public Map<String, Integer> getRepetitiveWords(TextComponent textComponent) {
        Map<String, Integer> map = new HashMap<>();
        for (TextComponent componentPar : textComponent.getTextComponent()) {
            for (TextComponent componentSent : componentPar.getTextComponent()) {
                String sentence = componentSent.collect();
                Pattern pattern = Pattern.compile(TextType.LEXEME.getRegex());
                Matcher matcher = pattern.matcher(sentence);
                while (matcher.find()) {
                    String substring = matcher.group().toLowerCase();
                    if (map.containsKey(substring)) {
                        map.put(substring, map.get(substring) + 1);
                    } else {
                        map.put(substring, 1);
                    }
                }
            }
        }
        int valueToRemove = 1;
        map.entrySet().removeIf(entry -> entry.getValue() == valueToRemove);
        return map;
    }

    public Map<String, Integer> getCountVowelConsonant(TextComponent textComponent) {
        Map<String, Integer> mapChar = new HashMap<>();
        mapChar.put("letter", 0);
        mapChar.put("vowel", 0);
        mapChar.put("consonant", 0);
        countCharacters(textComponent, mapChar);
        return mapChar;
    }

    private void countCharacters(TextComponent textComponent, Map<String, Integer> mapChar) {
        if (textComponent.getType() == TextType.LETTER) {
            mapChar.put("letter", mapChar.get("letter") + 1);
            String ch = textComponent.toString().toLowerCase();
            if (isVowel(ch)) {
                mapChar.put("vowel", mapChar.get("vowel") + 1);
            } else {
                mapChar.put("consonant", mapChar.get("consonant") + 1);
            }
        } else {
            for (TextComponent component : textComponent.getTextComponent()) {
                countCharacters(component, mapChar);
            }
        }
    }

    private boolean isVowel(String ch) {
        return "aeiouаеёиоуыэюя".contains(ch);
    }

}
