package com.ysl.stackStudy;


public class ArrayStack {
    /**
     * 数组实现顺序栈
     */
    private String[] items;

    private int count;

    /**
     * 申请一个大小为count的数组
     * @param count
     */
    public ArrayStack(int count) {
        items = new String[count];
        count = 0;
    }

    /**
     * 入栈
     */
    public Boolean push(String item){
        //数据空间不够了，入栈失败
        if(count == items.length){
            return false;
        }

        items[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈
     */
    public String pop(){
        //栈为空，返回null
        if(count == 0){
            return null;
        }

        String item = items[count-1];
        count--;
        return item;
    }

    /**
     * 栈实现表达式计算
     * @param args
     */

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("11");
        stack.push("22");
        stack.push("33");
        stack.push("44");

        stack.pop();
        stack.pop();

        stack.push("55");

        String item = stack.pop();

        String item1 = stack.pop();

        String item2 = stack.pop();

        System.out.println(item);

    }
}
