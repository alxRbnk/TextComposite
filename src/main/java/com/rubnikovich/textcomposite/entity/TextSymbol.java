package com.rubnikovich.textcomposite.entity;

public class TextSymbol implements TextComponent {
    private TextType type;
    private Character symbol;

    public TextSymbol(Character symbol) {
        this.symbol = symbol;
        this.type = setType();
    }

    @Override
    public String collect() {
        return symbol.toString();
    }

    @Override
    public void addComponent(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeComponent(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(symbol);
        return sb.toString();
    }

    private TextType setType() {
        type = TextType.PUNCTUATION;
        if (Character.isLetter(symbol)) {
            this.type = TextType.LETTER;
        }
        return type;
    }
}
