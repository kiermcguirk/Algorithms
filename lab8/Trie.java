package lab8;

public class Trie {
    // Alphabet size (# of symbols) we pick 26 for English alphabet
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean end; //leaf node

        TrieNode()        {
            end = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                this.children[i] = null;
        }
    }
    static TrieNode root;

    static void insert(String key)
    {
        int index;
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++)
        {
            index = key.charAt(i)-97;
            if (node.children[index]== null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }

        node.end = true;
    }
    // Returns true if key presents in trie, else false
    static boolean search(String key)
    {
        TrieNode node = root;
        int index;

        for (int i = 0; i < key.length(); i++)
        {
            index = key.charAt(i) - 97;
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return (node != null && node.end);
    }

    public static void main(String args[]) {

        mainCaller();
    }

    public static void mainCaller()
    {

        String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};
        root = new TrieNode();
        for (int i = 0; i < keys.length ; i++) {
            insert(keys[i]);
        }
        System.out.println("\n**Practical 8: Tries**");
        System.out.println("Expected true: 'bank' - Result:  "+ search("bank"));
        System.out.println("Expected true: 'book' - Result:  "+ search("book"));
        System.out.println("Expected true: 'bar' - Result:  "+ search("bar"));
        System.out.println("Expected true: 'bring' - Result:  "+ search("bring"));
        System.out.println("Expected true: 'film' - Result:  "+ search("film"));
        System.out.println("Expected true: 'filter' - Result:  "+ search("filter"));
        System.out.println("Expected true: 'simple' - Result:  "+ search("simple"));
        System.out.println("Expected true: 'silt' - Result:  "+ search("silt"));
        System.out.println("Expected true: 'silver' - Result:  "+ search("silver"));
        System.out.println("Expected false: 'kier' - Result:  "+ search("kier"));
    }
}