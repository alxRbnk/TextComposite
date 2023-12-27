package com.rubnikovich.textcomposite.service.Impl;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextType;
import com.rubnikovich.textcomposite.service.CustomService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomServiceImpl implements CustomService {
    private static CustomServiceImpl instance = new CustomServiceImpl();

    private CustomServiceImpl() {
    }

    public static CustomServiceImpl getInstance() {
        return instance;
    }

    public void sortParagraph(TextComponent textComponent) {
        Collections.sort(textComponent.getTextComponent(), (o1, o2) -> o1.getTextComponent().size() - o2.getTextComponent().size());
    }

    public TextComponent getSentenceWithBiggestLexeme(TextComponent textComponent) {
        TextComponent sentence = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < textComponent.getTextComponent().size(); i++) {
            for (int j = 0; j < textComponent.getTextComponent().get(i).getTextComponent().size(); j++) {
                for (int k = 0; k < textComponent.getTextComponent().get(i).getTextComponent().get(j).getTextComponent().size(); k++) {
                    int currentSize = textComponent.getTextComponent().get(i).getTextComponent().get(j).getTextComponent().get(k).getTextComponent().size();
                    if (currentSize > max) {
                        max = currentSize;
                        sentence = textComponent.getTextComponent().get(i).getTextComponent().get(j);
                    }
                }
            }
        }
        return sentence;
    }

    public void removeSentenceShorterThan(TextComponent textComponent, int countLexeme) {
        Iterator<TextComponent> paragraphIterator = textComponent.getTextComponent().iterator();
        while (paragraphIterator.hasNext()) {
            TextComponent sentence = paragraphIterator.next();
            Iterator<TextComponent> sentenceIterator = sentence.getTextComponent().iterator();
            while (sentenceIterator.hasNext()) {
                TextComponent lexeme = sentenceIterator.next();
                if (lexeme.getTextComponent().size() < countLexeme) {
                    sentenceIterator.remove();
                }
            }
        }
    }

    public Map<String, Integer> getRepetitiveWords(TextComponent textComponent) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < textComponent.getTextComponent().size(); i++) {
            for (int j = 0; j < textComponent.getTextComponent().get(i).getTextComponent().size(); j++) {
                String sentence = textComponent.getTextComponent().get(i).getTextComponent().get(j).collect();
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
        for (int i = 0; i < textComponent.getTextComponent().size(); i++) {
            for (int j = 0; j < textComponent.getTextComponent().get(i).getTextComponent().size(); j++) {
                for (int k = 0; k < textComponent.getTextComponent().get(i).getTextComponent().get(j).getTextComponent().size(); k++) {
                    for (int l = 0; l < textComponent.getTextComponent().get(i).getTextComponent().get(j).getTextComponent().get(k).getTextComponent().size(); l++) {
                        TextComponent character = textComponent.getTextComponent().get(i).getTextComponent().get(j).getTextComponent().get(k).getTextComponent().get(l);
                        if (character.getType() == TextType.LETTER) {
                            mapChar.put("letter", mapChar.get("letter") + 1);
                            String ch = character.toString().toLowerCase();
                            if (ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u") ||
                                    ch.equals("а") || ch.equals("е") || ch.equals("ё") || ch.equals("и") || ch.equals("о") ||
                                    ch.equals("у") || ch.equals("ы") || ch.equals("э") || ch.equals("ю") || ch.equals("я")) {
                                mapChar.put("vowel", mapChar.get("vowel") + 1);
                            } else {
                                mapChar.put("consonant", mapChar.get("consonant") + 1);
                            }
                        }
                    }
                }
            }
        }
        return mapChar;
    }

}
