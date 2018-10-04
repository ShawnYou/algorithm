package com.ysl.listStudy.joseph;

/**
 * @author aarony
 * @Created 2018-10-04 15:49
 * @E-mail aarony@synnex.com
 */
public class JosephProblem {
    /**
     * 双向循环链表实现约瑟夫环
     */
    class Child{
        int num;
        Child next = null;
        Child pre = null;

        public Child(int num) {
            this.num = num;
        }
    }

    //总共多少节点
    private int totalNum;

    //从第几个开始数
    private int startIndex;

    //数多少下
    private int coutNum;

    //首个节点
    private Child headChild = null;

    //临时节点
    private Child tempChild = null;

    //第几次游戏
    private int coutTime = 1;

    public JosephProblem(int totalNum, int startIndex, int coutNum) {
        this.totalNum = totalNum;
        this.startIndex = startIndex;
        this.coutNum = coutNum;
        initCirList();
        showList();
        processJoseph();
    }

    /**
     * 初始化 双向循环链表
     */
    void initCirList(){
        for (int i = 1;i<=totalNum;i++){
            if(i == 1){
                //头结点
                Child child = new Child(i);
                headChild = child;
                tempChild = child;
            }else if(i == totalNum){
                //尾节点
                Child child = new Child(totalNum);

                tempChild.next = child;
                child.pre = tempChild;

                child.next = headChild;
                headChild.pre = child;
            }else {
                //中间节点
                Child child = new Child(i);
                tempChild.next = child;
                child.pre = tempChild;

                //将当前节点 指向临时节点
                tempChild = child;
            }
        }
    }

    /**
     * 打印双向循环链表
     * @param
     */
    public void showList(){
        Child temp = headChild;

        do {
            System.out.println("编号为："+temp.next.num);
            temp = temp.next;
        }while (temp!=headChild);
    }

    /**
     * 进行约瑟夫问题
     */
    public void processJoseph(){
        Child cursor = headChild;
        //找到开始报数的人
        for(int i = 1;i<startIndex;i++){
            cursor = cursor.next;
        }

        while (totalNum!=1){

            //找到距离报数totalNum个节点 的节点
            for (int i = 0; i < coutNum; i++) {
                cursor = cursor.next;
            }

            System.out.println("第"+coutTime+"次出局人的编号"+cursor.num);
            //进行删除操作
            cursor.pre.next = cursor.next;
            cursor.next.pre = cursor.pre;

            //让cursor指向下一个报数的人
            cursor = cursor.next;

            totalNum--;
            coutTime++;
        }
        System.out.println("最后留下的人编号："+cursor.num);
    }

    public static void main(String[] args) {
        JosephProblem joseph = new JosephProblem(50,45,2);
    }
}
