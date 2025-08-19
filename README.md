# Anagram Finder

## Description

This program finds and groups words that are anagrams.  
Two words are anagrams if they contain the same letters in a different order.  
Example: `listen` and `silent`.

## How to Run

1. Make sure you have **Java** installed (version 8 or higher).
2. Place your input file in the `src` folder (example: `sample.txt`).
3. Open the project in an IDE (like IntelliJ IDEA) or use the command line.
4. Run the program. It will read the file and print groups of anagrams.

### Option 2: Run with Maven

1. Make sure you have **Maven** installed.
2. In the project root, run:
   ```bash
   mvn clean compile
   mvn exec:java
   ```

### Example Input (`sample.txt`):

care

race

listen

silent

hello

### Example Output:

care race

listen silent

hello

## How It Works

- The program reads all words from the file.
- It sorts the letters of each word.
- Words with the same letters are grouped together.
- The program prints each group of anagrams.

## Testing

This project includes unit tests written with **JUnit 5** and **AssertJ**.  
The tests check:

- That the program correctly groups words into anagrams.
- That the expected keys and groups are present.
- That the program throws an exception if the file is not found.

### How to Run Tests

If you are using **Maven**, run:

```bash
mvn test 
```

## Notes

- Empty lines in the file are ignored.
- The program can handle many words, but very large files may need more memory.


