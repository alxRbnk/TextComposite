package com.rubnikovich.textcomposite.service;

import com.rubnikovich.textcomposite.entity.TextComponent;

import java.util.Map;

public interface CustomService {

    void sortParagraph(TextComponent textComponent);

    TextComponent getSentenceWithBiggestLexeme(TextComponent textComponent);

    void removeSentenceShorterThan(TextComponent textComponent1, int countLexeme);

    Map<String, Integer> getRepetitiveWords(TextComponent textComponent);

    Map<String,Integer> getCountVowelConsonant(TextComponent textComponent1);

}
