package com.smile.datastructures.linkedList;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/11 15:53
 * @description：
 */
public class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");


    public HeroNode2 getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {

            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        boolean flag = false;
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getNo() == newHeroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.setName(newHeroNode.getName());
            temp.setNickName(newHeroNode.getNickName());
        } else {
            System.out.printf("没有找到编号【%d】的节点\r\n", newHeroNode.getNo());
        }

    }


    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        boolean flag = false;
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            if (temp.pre != null) {
                temp.pre.next = temp.next;
            }

            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("没有删除编号【%d】的节点\r\n", no);
        }
    }


    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;

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
            heroNode.pre = temp;
            if (temp.next != null) {
                temp.next.pre = heroNode;
            }
            temp.next = heroNode;

        }
    }

}
