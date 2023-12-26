package com.rubnikovich.textcomposite.service;

import com.rubnikovich.textcomposite.entity.TextComponent;

import java.util.Map;

public interface CustomService {

    public void sortParagraph(TextComponent textComponent);

    public TextComponent getSentenceWithBiggestLexeme(TextComponent textComponent);

    public void removeSentenceShorterThan(TextComponent textComponent1, int countLexeme);

    public Map<String, Integer> getRepetitiveWords(TextComponent textComponent);

    public Map<String,Integer> getCountVowelConsonant(TextComponent textComponent1);

}
