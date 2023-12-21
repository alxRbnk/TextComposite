package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;

public abstract class AbstractHandler {
    public abstract TextComponent handleRequest(String text);
}
