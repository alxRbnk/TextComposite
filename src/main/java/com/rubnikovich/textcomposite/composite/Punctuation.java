package com.rubnikovich.textcomposite.composite;

public class Punctuation implements TextComponent {
    private TextType type;
    private Character punctuation;

    public Punctuation(char punctuation){
        this.punctuation = punctuation;
        this.type = TextType.PUNCTUATION;
    }

    @Override
    public String collect() {
        return punctuation.toString();
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

}
