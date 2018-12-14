import java.util.*;

public class TrieImpl {

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfNode;

        public TrieNode() {
            this.children = new HashMap<>();
            this.endOfNode = false;
        }
    }

    private TrieNode root;

    public TrieImpl() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfNode = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfNode;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    public boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfNode) {
                return false;
            }
            current.endOfNode = false;
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        TrieImpl trie = new TrieImpl();
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("efg");

        System.out.println(trie.search("abc"));
        System.out.println(trie.search("bcd"));

        System.out.println(trie.delete("abc"));
        System.out.println(trie.search("abc"));
    }
}
