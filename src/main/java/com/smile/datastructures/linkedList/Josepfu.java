package com.smile.datastructures.linkedList;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/12 18:36
 * @description：
 */
public class Josepfu {

    public static void main(String[] args) {
        int count = 25;
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(count);
        circleSingleLinkedList.shoBoy();
        System.out.println("========出圈======");
        circleSingleLinkedList.countBoy(1, 2, count);


    }


}

class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("数据不正确");
            return;
        }

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;

            }

        }
    }


    /**
     * @param startNo  从第几个开始
     * @param countNum 间隔数
     * @param nums     表示最初有多少个节点
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误请重新输入!");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
                //first 节点为出圈
                System.out.printf("小孩【%d】出圈\r\n", first.getNo());

                first = first.getNext();
                helper.setNext(first);
            }
        }
        System.out.printf("最后留在圈中的小孩【%d】\r\n", first.getNo());
    }


    public void shoBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号:【%d】\r\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }

    }
}


class Boy {
    private int no;

    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}