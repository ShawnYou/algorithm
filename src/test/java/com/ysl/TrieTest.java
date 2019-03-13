package com.ysl;

import com.ysl.trieTree.Trie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawn_lin on 2019/2/24.
 */

public class TrieTest extends BaseTest {

    private static Trie trie = new Trie();

    private static List<String> testData = new ArrayList<String>();

    @Before
    public void init(){
        testData.add("hello");
        testData.add("how");
        testData.add("her");
        testData.add("so");
        testData.add("see");

        testData.forEach(text ->{
            trie.insert(text);
        });
    }

    @Test
    public void testFindText(){
        boolean isExist = trie.findText("how");
        Assert.assertEquals(true,isExist);

        boolean isExist1 = trie.findText("howx");
        Assert.assertEquals(false,isExist1);

        boolean isExist2 = trie.findText("hello");
        Assert.assertEquals(true,isExist2);

    }

}
