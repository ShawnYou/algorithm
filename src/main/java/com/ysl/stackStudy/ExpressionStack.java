package com.ysl.stackStudy;

/**
 * @author aarony
 * @Created 2018-10-08 10:53
 * @E-mail aarony@synnex.com
 */
public class ExpressionStack {
    /**
     * 两个栈 实现算术表达式求值
     */
    //TODO NOT IMPLEMENTS
    private static int calc(String exp){
        //操作数栈
        LinkStack<Integer> dataStack = new LinkStack<Integer>();

        //操作符栈
        LinkStack<Character> charStack = new LinkStack<Character>();
        int i = 0;
        char ch = exp.charAt(i);

        charStack.push('#');

        while (ch!='#'||charStack.peek()!='#'){
            if(ch>='0'&&ch<='9'){
                dataStack.push(Integer.parseInt(ch+""));
            }else {
                char peekChar = charStack.peek();

            }
        }
        return 0;
    }

    private static int getOrder(char ch){
        int index = -1;
        switch (ch){
            case '+':
                index = 0;
                break;
            case  '-':
                index = 1;
                break;
            case  '*':
                index = 2;
                break;
            case '/':
                index = 3;
                break;
        }
        return index;
    }
}
