package com.smile.datastructures.linkedList;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/11 16:06
 * @description：
 */
public class DoubleLinkedListTest {

    public static void main(String[] args) {
        System.out.println("双向链表的测试:");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 heroNode1 = new HeroNode2(1,"a","a");
        HeroNode2 heroNode2 = new HeroNode2(2,"b","b");
        HeroNode2 heroNode3 = new HeroNode2(3,"c","c");
        HeroNode2 heroNode4 = new HeroNode2(4,"d","d");
//        doubleLinkedList.add(heroNode1);
//        doubleLinkedList.add(heroNode2);
//        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.add(heroNode4);
//
//        doubleLinkedList.list();
//
//        System.out.println("=========update======");
//        HeroNode2 heroNode3_2 = new HeroNode2(3,"ccc","ccc");
//        doubleLinkedList.update(heroNode3_2);
//        doubleLinkedList.list();
//
//        System.out.println("===========delete=========");
//        doubleLinkedList.delete(3);
//        doubleLinkedList.list();

        System.out.println("======order add====");
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.addByOrder(heroNode3);
        doubleLinkedList.list();

    }

}
