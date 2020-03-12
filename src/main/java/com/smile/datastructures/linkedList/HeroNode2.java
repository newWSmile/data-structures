package com.smile.datastructures.linkedList;

import java.util.StringJoiner;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/3/10 18:17
 * @description：
 */
public class HeroNode2 {

    private int no;

    private String name;

    private String nickName;

    public HeroNode2 next;

    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", HeroNode2.class.getSimpleName() + "[", "]")
                .add("no=" + no)
                .add("name='" + name + "'")
                .add("nickName='" + nickName + "'")
                .toString();
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
