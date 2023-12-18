package com.rubnikovich.textcomposite.chain;

import com.rubnikovich.textcomposite.composite.TextComponent;

public abstract class AbstractHandler {
    public abstract String handleRequest(TextComponent textComponent, String line);
}
