package com.ysl.listStudy.singleList;


public class SingleList {
    /**
     * 单链表
     */
    public Node head;

    public int length(){
        int len = 0;
        Node temp = head;
        while (temp.next!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public SingleList() {
        initList();
    }

    void initList(){
        head = new Node(null);
        head.next = null;
    }

    /**
     * 链表反转(1)
     *  关键：定义三个指针
     *
     */
    public void reverseList1(){
        if(head == null || head.next == null){
            return;
        }

        Node pre = head.next;
        Node qre = head.next.next;
        Node cursor;
        head.next.next = null;
        while (qre!=null){
            cursor = qre.next;
            qre.next = pre;

            pre = qre;
            qre = cursor;
        }
        Node front = new Node(null);
        front.next = pre;
        head = front;
    }

    /**
     *  链表反转（2）
     *  对于一条链表，可以从第二个节点到N个节点 依次插入到第一个节点后，N-1个操作之后，再将第一个节点挪到新表的末尾
     */
    public void reverseList2(){


    }

    /**
     *  链表反转（3）
     *  递归实现链表反转
     */
    public Node reverseList3(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head.next;
        Node newNode = reverseList3(head.next);

        temp.next = head;
        head.next = null;

        return newNode;
    }

    /**
     * 末尾增加节点
     * @param node
     */
    public void addNode(Node node){
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        //最后一个节点 或者头节点， next指向新的节点
        temp.next = node;
    }

    /**
     * 在指定位置插入节点
     * 关键：找到需要插入位置的前一个节点
     * @param index（链表的位置）
     * @param node （插入的节点）
     */
    public void insertNodeByIndex(int index,Node node){
        //判断指定位置是否合法
        if(index<1||index>length()+1){
            System.out.println("位置不合法");
            return;
        }

        Node temp = head;
        int length = 1;
        while (temp.next!=null){
            //temp表示当前位置的前一个节点
            if(index == length++){
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 求单链表的中间节点
     */
    public Node getMidNode(){
        Node oneStep = head;
        Node twoStep = head;
        while (twoStep!=null&&twoStep.next!=null){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return oneStep;
    }

    /**
     * 删除链表倒数第n个节点
     *  关键：双指针, 总共n个节点
     *  (1)先让快指针 先前进index个节点
     *  (2)快指针和满指针一起前进，当快指针到达末尾的时候（前进了n-index个节点），满指针所在的位置就是倒数n个节点
     */
    public Node deleteNodeFromEnd(int index){
        if(index>length()){
            System.out.println("index输入不合规范");
            return null;
        }

        Node fastNode = head;
        Node slowNode = head;
        for (int i = 0; i < index; i++) {
            fastNode = fastNode.next;
        }

        if(fastNode == null){
            return head.next;
        }

        while (fastNode.next!=null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;

        return head;
    }

    /**
     * 指定的位置删除节点
     * 关键：找到当前位置的前一个节点
     * @param index
     */
    public void deleteNodeByIndex(int index){
        //判断指定位置是否合法
        if(index<1||index>length()+1){
            System.out.println("位置不合法");
            return;
        }
        Node temp = head;
        int length = 1;
        while (temp.next!=null){
            if(index == length++){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 判断链表是否有环
     *  关键：快慢指针
     *  如果有环的话，经过一些步， 快慢指针会相遇
     *
     */
    public Boolean isCycle(){
        Node fast = head;
        Node slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addNode(new Node(1));
        singleList.addNode(new Node(2));
        singleList.addNode(new Node(3));
        singleList.addNode(new Node(4));
        singleList.addNode(new Node(5));
        singleList.addNode(new Node(6));

        singleList.insertNodeByIndex(3,new Node(11));

        Node midNode = singleList.getMidNode();
        System.out.println("链表中间节点的编号："+midNode.t);

        //singleList.deleteNodeFromEnd(1);

        //singleList.deleteNodeByIndex(5);

        Boolean isCircle = singleList.isCycle();

        //singleList.reverseList1();

        singleList.reverseList3(singleList.head);

        System.out.println("是否有环："+isCircle);
        System.out.println(singleList);
    }
}
