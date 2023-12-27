package com.rubnikovich.textcomposite.entity;

import com.rubnikovich.textcomposite.parser.*;

public enum TextType {
    TEXT("( {4}.*?(?= {4})| {4}.+)", new SentenceParser()),
    PARAGRAPH("(( {1,4}[A-Z].*?\\.(?= [A-Z]))|( {1,4}[A-Z].*))", new LexemeParser()),
    SENTENCE("( {1,4}.*?(?= ))|( {1,4}.*)", new SymbolParser()),
    LEXEME("\\b\\S+\\b"),
    LETTER(),
    PUNCTUATION();

    private String regex;
    private AbstractParser successor;

    TextType() {
    }

    TextType(String regex){
        this.regex = regex;
    }

    TextType(String regex, AbstractParser successor) {
        this.regex = regex;
        this.successor = successor;
    }

    public String getRegex() {
        return this.regex;
    }

    public AbstractParser getSuccessor() {
        return this.successor;
    }

}
