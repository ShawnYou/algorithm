package com.ysl.search;

import com.ysl.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author aarony
 * @Created 2019-03-13 15:57
 * @E-mail aarony@synnex.com
 */
public class BinarySearchPlusTest extends BaseTest{
    private int[] data;

    private BinarySearchPlus binarySearchPlus;

    @Before
    public void init(){
        binarySearchPlus = new BinarySearchPlus();
        data = new int[]{1,3,4,5,5,5,8,9};
    }

    @Test
    public void shouldReturnFirstEqualWhenHasRepeatElement(){
        int index = binarySearchPlus.binarySearchFindFirstElement(data,data.length-1,5);
        Assert.assertEquals(3,index);
    }

    @Test
    public void shouldReturnLastIndexWhenhasRepeatElement(){
        int index = binarySearchPlus.binarySearchFindListElement(data,data.length-1,5);
        Assert.assertEquals(5,index);
    }

    @Test
    public void shouldReturnFirstLargeAndEqualsElement(){
        int index = binarySearchPlus.binarySearchFindFirstLargerAndEqualsElement(data,data.length-1,6);
        Assert.assertEquals(6,index);
    }

    @Test
    public void shouldReturnLastlessAndEqualsElement(){
        int index = binarySearchPlus.binarySearchFindLastLessAndEqualsElement(data,data.length-1,7);
        Assert.assertEquals(5,index);
    }
}
