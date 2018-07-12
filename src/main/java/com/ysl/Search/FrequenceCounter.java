package com.ysl.Search;


import com.ysl.util.IOUtil;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * Created by shawn_lin on 2018/7/8.
 */
public class FrequenceCounter {
    //测试出现的频率
    public static void main(String[] args) throws Exception{
        Scanner scanner = IOUtil.readFile();
        //最小键长
        int minlen = Integer.parseInt(args[0]);
        BinarySearchST<String,Integer> st = new BinarySearchST<String,Integer>(2);
        /*while (scanner.hasNext()){
            String word = scanner.next();
            if(word.length()<minlen){
                continue;
            }
            if(!st.contains(word)){
                st.put(word,0);
            }else {
                st.put(word,st.get(word)+1);
            }
        }*/
        //找出频率最高的单词
        /*String max = "";
        st.put(max,0);
        for (String word:st.keys()){
            if(st.get(word)>st.get(max)){
                max = word;
            }
        }
        StdOut.println(max+" "+st.get(max));*/
    }

}
