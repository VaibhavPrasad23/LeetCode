import java.util.*;

public class StreamChecker {
    private class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isEndOfWord;
    }

    private TrieNode root;
    private List<Character> stream;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new ArrayList<>();

        // Insert reversed words into the Trie
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.isEndOfWord = true;
        }
    }

    public boolean query(char letter) {
        // Add the letter to the stream
        stream.add(letter);

        // Traverse the Trie from the current stream's end
        TrieNode node = root;
        for (int i = stream.size() - 1; i >= 0; i--) {
            char ch = stream.get(i);
            if (!node.children.containsKey(ch)) {
                // If no match is found, reset node to root and return false
                return false;
            }
            node = node.children.get(ch);
            if (node.isEndOfWord) {
                return true; // Word found
            }
        }
        return false; // No match found
    }
}


/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */


