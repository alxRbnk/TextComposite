package com.rubnikovich.textcomposite.composite;

public class Letter implements TextComponent {
    private TextType type;
    private Character letter;

    public Letter(char letter){
        this.letter = letter;
        this.type = TextType.LETTER;
    }

    @Override
    public String collect() {
        return letter.toString();
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
