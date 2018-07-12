package com.ysl.util;

import java.io.File;
import java.util.Scanner;

/**
 * Created by shawn_lin on 2018/7/9.
 */
public class IOUtil {
    public static Scanner readFile(){
        File file = new File("/ysl/workspace/algorithm-data/algs4-data/tinyST.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }catch (Exception e){

        }
        return scanner;
    }
}
