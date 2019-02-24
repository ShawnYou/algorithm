package com.ysl.trieTree;

import org.apache.commons.lang.StringUtils;

/**
 * Created by shawn_lin on 2019/2/24.
 *  Trie tree(字典树) 使用数组进行存储
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    public void insert(String text){
        TrieNode p = root;

        if(StringUtils.isEmpty(text)){ throw new RuntimeException("insert param should not be null");}

        char[] charArr = text.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i] - 'a';

            if(p.children[index] == null) {
                TrieNode trieNode = new TrieNode(charArr[i]);
                p.children[index] = trieNode;
            }

            p = p.children[index];
        }
        p.isEnding = true;
    }

    public boolean findText(String text){
        TrieNode p = root;

        if(StringUtils.isEmpty(text)){ throw new RuntimeException("query param should not be null");}

        char[] charArr = text.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i] - 'a';

            if(p.children[index] == null){ return false; }

            p = p.children[index];
        }

        if(p.isEnding == false){ return false;}
        return true;
    }

    class TrieNode{
        private char data;
        private TrieNode[] children = new TrieNode[26];
        private boolean isEnding = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
