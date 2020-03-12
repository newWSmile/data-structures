package com.smile.datastructures.linkedList;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/10 18:19
 * @description：
 */
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;

        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.getNo() > heroNode.getNo()) {
                break;
            } else if (temp.next.getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.next;

        }

        if (flag) {
            System.out.printf("准备插入的英雄编号【%d】已存在,不能加入\r\n", heroNode.getNo());
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void showLinkedList() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {

            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }


    public void update(HeroNode newHeroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        boolean flag =false;
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() == newHeroNode.getNo()){
                flag = true;
                break;
            }
            temp =temp.next;
        }
        if (flag){
            temp.setName(newHeroNode.getName());
            temp.setNickName(newHeroNode.getNickName());
        }else {
            System.out.printf("没有找到编号【%d】的节点\r\n",newHeroNode.getNo());
        }

    }


    public void delete(int no){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        boolean flag = false;
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.getNo() == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("没有删除编号【%d】的节点\r\n",no);
        }
    }
}
