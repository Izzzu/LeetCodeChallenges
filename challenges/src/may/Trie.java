package may;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    static final int alphabetLength = 26;
    private List<Trie> children;
    boolean isLeaf;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

        children = new ArrayList<>();
        for (int i = 0; i < alphabetLength; i++) {
            children.add(null);
        }


    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        Trie current = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            Trie trie = current.children.get(index);
            if (trie == null) {
                trie = new Trie();
                current.children.set(index, trie);
            }
            current = current.children.get(index);
        }
        current.isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            Trie trie = current.children.get(index);
            if (trie == null) {
                return false;
            }
            current = trie;
        }
        return current.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie current = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            Trie trie = current.children.get(index);
            if (trie == null) {
                return false;
            }
            current = trie;
        }
        return true;

    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.startsWith("app"));
        System.out.println(obj.search("app"));


    }

}
