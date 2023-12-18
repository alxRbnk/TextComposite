package com.rubnikovich.textcomposite.main;

import com.rubnikovich.textcomposite.composite.*;

public class Main {
    public static void main(String[] args) {

        for (int i = 65; i < 123; i++) //65-90 A-Z;  97-122 a-z
            System.out.print((char) i);
        System.out.println();

        TextComponent letter = new Letter('d');
        TextComponent punctuation = new Punctuation('.');

        TextComponent lexeme1 = new TextComposite(TextType.LEXEME);
        lexeme1.addComponent(letter);
        lexeme1.addComponent(punctuation);
        TextComponent lexeme2 = new TextComposite(TextType.LEXEME);
        lexeme2.addComponent(letter);
        lexeme2.addComponent(punctuation);
        TextComponent lexeme3 = new TextComposite(TextType.LEXEME);
        lexeme3.addComponent(letter);
        lexeme3.addComponent(punctuation);
        TextComponent lexeme4 = new TextComposite(TextType.LEXEME);
        lexeme4.addComponent(letter);
        lexeme4.addComponent(punctuation);
        TextComponent lexeme5 = new TextComposite(TextType.LEXEME);
        lexeme5.addComponent(letter);
        lexeme5.addComponent(punctuation);
        TextComponent lexeme6 = new TextComposite(TextType.LEXEME);
        lexeme6.addComponent(letter);
        lexeme6.addComponent(punctuation);
        TextComponent lexeme7 = new TextComposite(TextType.LEXEME);
        lexeme7.addComponent(letter);
        lexeme7.addComponent(punctuation);
        TextComponent lexeme8 = new TextComposite(TextType.LEXEME);
        lexeme8.addComponent(letter);
        lexeme8.addComponent(punctuation);

        TextComponent sentence1 = new TextComposite(TextType.SENTENCE);
        sentence1.addComponent(lexeme1);
        sentence1.addComponent(lexeme2);
        TextComponent sentence2 = new TextComposite(TextType.SENTENCE);
        sentence2.addComponent(lexeme3);
        sentence2.addComponent(lexeme4);
        TextComponent sentence3 = new TextComposite(TextType.SENTENCE);
        sentence3.addComponent(lexeme5);
        sentence3.addComponent(lexeme6);
        TextComponent sentence4 = new TextComposite(TextType.SENTENCE);
        sentence4.addComponent(lexeme7);
        sentence4.addComponent(lexeme8);

        TextComponent paragraph1 = new TextComposite(TextType.PARAGRAPH);
        paragraph1.addComponent(sentence1);
        paragraph1.addComponent(sentence2);

        TextComponent paragraph2 = new TextComposite(TextType.PARAGRAPH);
        paragraph2.addComponent(sentence3);
        paragraph2.addComponent(sentence4);

        TextComponent text = new TextComposite(TextType.TEXT);
        text.addComponent(paragraph1);
        text.addComponent(paragraph2);

        System.out.println(text.collect());
        System.out.println(paragraph1.collect());
        System.out.println(paragraph2.collect());
        System.out.println(text.count());


    }
}
/*
    It has survived - not only (five) centuries, but also the leap into electronic typesetting,
remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the
release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently
with desktop publishing software like Aldus PageMaker Faclon9 including versions of
Lorem Ipsum!
    It is a long a!=b established fact that a reader will be distracted by the readable
content of a page when looking at its layout. The point of using  Ipsum is that it has a more-
or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content
here's, making it look like readable English?
    It is a established fact that a reader will be of a page when looking at its layout...
    Bye бандерлоги.
*/