package com.smile.datastructures.hashTable;

import java.util.Scanner;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/4/16 14:21
 * @description：
 */
public class HashTableDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=====菜单栏start=======");
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");
            System.out.println("======菜单栏end======");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                case "find":
                    System.out.println("输入id");
                    hashTab.findEmpById(scanner.nextInt());
                    break;
                default:
                    break;

            }
        }
    }

}

class HashTab {
    private EmpLinkedList[] empLinkedListArray;

    private int size;

    public HashTab(int size) {
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
        this.size = size;
    }

    public void add(Emp emp) {
        int empLinkedListNo = hashFunc(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i + 1);
        }
    }

    public void findEmpById(int id) {
        int empLinkedListNo = hashFunc(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (null != emp) {
            System.out.printf("在第%d条链表中找到改雇员 id=%d,name=%s", empLinkedListNo, emp.id, emp.name);
            System.out.println();
        } else {
            System.out.println("在hash表中没有找到该雇员");
        }
    }

    //散列得到是哪个链表
    private int hashFunc(int id) {
        return id % size;
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "当前链表为空");
            return;
        }
        System.out.print("第" + no + "当前链表信息为:");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=>id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                return curEmp;
            }
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        return null;
    }

}

class Emp {
    public int id;
    public String name;

    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}