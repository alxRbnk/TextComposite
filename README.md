# Text Parsing Project Using Chain of Responsibility and Composite Patterns

## Description

This project demonstrates the use of the Chain of Responsibility and Composite design patterns for text parsing. The Chain of Responsibility pattern is used for processing text at various levels (e.g., splitting into sentences, words, etc.), while the Composite pattern is used to represent the hierarchy of parsed elements (e.g., text consisting of sentences, which consist of words).

## Structure

- `src/`
  - `com/rubnikovich/textcomposite/entity/` - Contains the Composite pattern implementation for text elements.
  - `com/rubnikovich/textcomposite/parser/` - Contains the Chain of Responsibility pattern implementation for parsing text.
  - `com/rubnikovich/textcomposite/service/` - Contains services for manipulating and analyzing the text components.
- `resources/`
  - `example.txt` - Example text for parsing.

### Composite Pattern

The Composite pattern is implemented to represent a hierarchy of text elements such as paragraphs, sentences, and words. The key classes are:

- `TextComponent` - The base interface for all text components.
- `TextComposite` - A composite class that can hold other `TextComponent` objects.
- `TextSymbol` - A leaf class representing individual characters.

### Chain of Responsibility Pattern

The Chain of Responsibility pattern is implemented to parse the text in sequential steps. The key classes are:

- `AbstractParser` - The base class for all parsers in the chain.
- `SentenceParser`, `LexemeParser`, `ParagraphParser`, `SymbolParser` - Concrete parser classes that handle specific levels of parsing.

### Services

The `CustomServiceImpl` class provides various services for manipulating and analyzing the text components:

- `sortParagraph` - Sorts paragraphs by the number of sentences.
- `getSentenceWithBiggestLexeme` - Finds the sentence with the largest lexeme.
- `removeSentenceShorterThan` - Removes sentences shorter than a specified number of lexemes.
- `getRepetitiveWords` - Identifies and counts repetitive words in the text.
- `getCountVowelConsonant` - Counts the number of vowels, consonants, and letters in the text.

