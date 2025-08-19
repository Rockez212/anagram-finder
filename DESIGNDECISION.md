# Design Decisions and Scalability

## Design Decisions

I used a `HashMap<String, Set<String>>` to group words by sorted letters.  
This makes it easy to find groups of anagrams quickly.  
The program reads words from a file, sorts letters, and puts them in the map.

For testing, I used **JUnit 5** and **AssertJ** libraries to make the tests clear and expressive.  
The code is designed to be simple, easy to read, and maintainable.

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
