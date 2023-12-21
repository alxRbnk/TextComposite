package com.rubnikovich.textcomposite.reader.impl;

import com.rubnikovich.textcomposite.exception.CustomException;
import com.rubnikovich.textcomposite.reader.CustomReader;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class CustomReaderImpl implements CustomReader {
    public String read(String filePath) throws CustomException {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new CustomException(e);
        }
        return stringBuilder.toString();
    }
}
