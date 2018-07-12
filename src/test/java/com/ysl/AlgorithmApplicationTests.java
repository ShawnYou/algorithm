package com.ysl;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testST(){

		ST<String,Integer> st = new ST<String,Integer>();
		for(int i = 0; !StdIn.isEmpty();i++){
			 String key = StdIn.readString();
			 st.put(key,i);
		}
		for(String s:st.keys()){
			StdOut.println(s+""+st.get(s));
		}

	}

}
