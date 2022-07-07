package com.xia.trietree;

import org.junit.Test;
import tiretree.ArrayTrie;

/**
 * @author xwfstart
 * @create 2022-07-07 23:40
 */
public class TestTrie {
    @Test
    public void test() {
        ArrayTrie arrayTrie = new ArrayTrie();
        arrayTrie.insert("asdfg");
        arrayTrie.insert("asd");
        arrayTrie.insert("asdfgh");
        System.out.println(arrayTrie.search("as"));
        System.out.println(arrayTrie.startWith("asdf"));
    }
}
