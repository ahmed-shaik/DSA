package Graphs.Hard;

import java.util.*;

public class WordLadder {

    public class Solution {

        // Normal Pair class to hold String word and int level
        class Pair {
            String word;
            int level;

            // Constructor
            public Pair(String word, int level) {
                this.word = word;
                this.level = level;
            }

            // Getter for word
            public String getWord() {
                return word;
            }

            // Getter for level
            public int getLevel() {
                return level;
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // If the endWord is not in the wordList, return 0
            if (!wordList.contains(endWord)) {
                return 0;
            }

            // Queue for BFS: holds Pair(word, level)
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(beginWord, 1)); // Initialize with the beginWord and level 1

            // Set for storing the words from the word list for O(1) lookup
            Set<String> hs = new HashSet<>(wordList);
            hs.remove(beginWord); // Remove the beginWord from the set to avoid revisiting

            while (!q.isEmpty()) {
                // Get the current Pair (word, level) from the queue
                Pair current = q.poll();
                String currentWord = current.getWord();
                int level = current.getLevel();

                // Try changing each character of the current word
                for (int i = 0; i < currentWord.length(); i++) {
                    char[] wordArray = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[i] = c;
                        String nextWord = new String(wordArray);

                        // If the next word is the endWord, return the current level + 1
                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If the next word is in the word list and hasn't been visited yet
                        if (hs.contains(nextWord)) {
                            q.add(new Pair(nextWord, level + 1)); // Add the next word with the updated level
                            hs.remove(nextWord); // Remove from set to avoid revisiting
                        }
                    }
                }
            }

            // If no transformation sequence exists, return 0
            return 0;
        }

        // public static void main(String[] args) {
        // Solution sol = new Solution();
        // List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log",
        // "cog");
        // int result = sol.ladderLength("hit", "cog", wordList);
        // System.out.println(result); // Output: 5 (hit -> hot -> dot -> dog -> cog)
        // }
    }
}
