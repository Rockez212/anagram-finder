# Design Decisions and Scalability

## Design Decisions
I used a HashMap<String, Set<String>> to group words by sorted letters.  
This makes it easy to find groups of anagrams quickly.  
The program reads words from a file, sorts letters, and puts them in the map.  
I did not use any external libraries to keep the project simple and clear.  
The code is easy to read and maintain.

## Scalability Considerations
- For 10 million words:  
  The program can work if there is enough RAM. If memory is small, we can save intermediate results to files or a database.

- For 100 billion words:  
  We cannot keep all words in memory. We would need distributed systems like Hadoop or Spark to process data in parts.  
  We can also store results in a database and merge them later.  
  Sorting and grouping can be done in parallel to make it faster.
