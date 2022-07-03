package tiretree;

/**
 * @author xwfstart
 * @create 2021-10-23 11:56
 */
public class TestTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("rfdlovell");
        trie.insert("baodaamy");
        trie.insert("aamy");
        System.out.println(trie.search("aamy"));
        System.out.println(trie.startsWith("aa"));
    }
}
