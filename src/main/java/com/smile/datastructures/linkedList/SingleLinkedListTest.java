package com.smile.datastructures.linkedList;

import java.util.Stack;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/10 18:19
 * @description：
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1,"a","a");
        HeroNode heroNode2 = new HeroNode(2,"b","b");
        HeroNode heroNode3 = new HeroNode(3,"c","c");
        HeroNode heroNode4 = new HeroNode(4,"d","d");
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.showLinkedList();

        HeroNode heroNode4_4 = new HeroNode(4,"dd","dd");
        singleLinkedList.update(heroNode4_4);
        System.out.println("======update=====");
        singleLinkedList.showLinkedList();


        System.out.println("======delete===========");

//        singleLinkedList.delete(3);
//        singleLinkedList.delete(2);
        singleLinkedList.delete(5);
        singleLinkedList.showLinkedList();

        System.out.println("=====反转=========");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.showLinkedList();

        System.out.println("=======正序=======");
        singleLinkedList.showLinkedList();
        System.out.println("======逆序======");
        reverseShowList(singleLinkedList.getHead());



    }


    //逆序打印  利用栈 后进先出的原理
    public static void reverseShowList(HeroNode head){
        if (head.next == null ){
            return ;
        }
        HeroNode temp = head.next;
        Stack stack = new Stack();
        while (true){
            if (temp ==null){
                break;
            }

            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }


    //单链表反转
    public static void reverseList(HeroNode head){
        if (head.next==null || head.next.next == null){
            return ;
        }

        HeroNode currentNode = head.next;
        HeroNode next = null;

        HeroNode reverseHead = new HeroNode(0,"","");

        while(currentNode != null){
            next = currentNode.next;
            currentNode.next = reverseHead.next;
            reverseHead.next = currentNode;
            currentNode = next;

        }
        head.next = reverseHead.next;





    }

}
