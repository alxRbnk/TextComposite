package com.rubnikovich.textcomposite.reader;

import com.rubnikovich.textcomposite.exception.CustomException;

public interface CustomReader {
    String read(String filePath) throws CustomException;
}
