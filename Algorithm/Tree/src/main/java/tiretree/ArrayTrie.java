package tiretree;

/**
 * @author xwfstart
 * @create 2022-07-07 23:33
 */
public class ArrayTrie {
    int N = 100000, M = 26;
    int[][] trie = new int[N][M];
    boolean[] isEnd = new boolean[N];
    int index;

    public void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                trie[p][u] = ++index;
            }
            p = trie[p][u];
        }
        isEnd[p] = true;
    }

    public boolean search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                return false;
            }
            p = trie[p][u];
        }
        return isEnd[p];
    }

    public boolean startWith(String s) {
        for (int i = 0, p = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                return false;
            }
            p = trie[p][u];
        }
        return true;
    }
}
