# Design Decisions and Scalability

## Design Decisions

- **Data Structure:** I used `HashMap<String, Set<String>>` where the key is the sorted letters of a word,  
  and the value is a set of words that share the same letters. This allows fast grouping of anagrams and avoids
  duplicates.

- **Key Generation:** Each word is converted to a character array, sorted, and joined back into a string.  
  All anagrams share the same key (e.g., `listen → eilnst`, `silent → eilnst`).

- **File Reading:** `BufferedReader` reads the file line by line to save memory. Empty lines are ignored.

- **Error Handling:** If the file cannot be read, an `IOException` is thrown and logged to `System.err`.

- **Testing:** I used **JUnit 5** and **AssertJ** to check correct grouping, expected keys, and file-not-found behavior.

- **Simplicity:** The logic is simple, readable, and easy to maintain, without extra libraries for core functionality.

## Scalability Considerations

**How would my solution handle 10 million words?**  
The program can handle around 10 million words on a single machine if there is enough RAM.  
To optimize performance in the future:

- Use efficient data structures (`HashMap`, `StringBuilder`).
- Stream the file line by line instead of loading everything into memory at once.
- Optionally write intermediate groups to disk or a database if memory becomes a bottleneck.

**What changes would be needed for 100 billion words?**  
For this scale, a single machine is not enough.  
We would need a **distributed system** to process data in parallel. Possible approaches:

- Store intermediate results in distributed storage (cloud storage, or a database).
- Perform **map-reduce style grouping** where each node groups local words, and then results are merged.

**General scaling strategy:**

- Parallelize sorting and grouping operations.
- Use external storage (databases, distributed file systems) instead of memory.
- Optimize algorithms to minimize string operations and memory copies.
