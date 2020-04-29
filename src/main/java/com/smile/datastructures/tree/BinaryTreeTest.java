package com.smile.datastructures.tree;

import java.util.StringJoiner;

/**
 * @author ：Smile(wangyajun)
 * @date ：Created in 2020/4/29 10:36
 * @description：
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        SmileNode node1 = new SmileNode(1, "smile");
        SmileNode node2 = new SmileNode(2, "jane");
        SmileNode node3 = new SmileNode(3, "tennis");
        SmileNode node4 = new SmileNode(4, "jack");
        SmileNode node5 = new SmileNode(5, "nice");

        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        node3.setRightNode(node4);
        node3.setLeftNode(node5);

        BinaryTree binaryTree = new BinaryTree(node1);
        System.out.println("====前序=====");
        binaryTree.preOrder();
        System.out.println("======中序======");
        binaryTree.infixOrder();
        System.out.println("=======后序=======");
        binaryTree.postOrder();


        System.out.println("=====前序查找====");
        SmileNode smileNode1 = binaryTree.preSearch(5);
        System.out.println(smileNode1);
        System.out.println("=====中序查找====");
        SmileNode smileNode2 = binaryTree.infixSearch(5);
        System.out.println(smileNode2);
        System.out.println("=====后序查找====");
        SmileNode smileNode3 = binaryTree.postSearch(5);
        System.out.println(smileNode3);
    }


}

class BinaryTree {
    private SmileNode root;

    public BinaryTree(SmileNode root) {
        this.root = root;
    }


    public SmileNode preSearch(int id) {
        if (this.root != null) {
            return this.root.preSearch(id);
        }
        return null;
    }


    public SmileNode infixSearch(int id) {
        if (this.root != null) {
            return this.root.infixSearch(id);
        }
        return null;
    }

    public SmileNode postSearch(int id) {
        if (this.root != null) {
            return this.root.postSearch(id);
        }
        return null;
    }

    public void preOrder() {
        if (this.root != null) {
            root.preOrder();
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            root.infixOrder();
        }
    }


    public void postOrder() {
        if (this.root != null) {
            root.postOrder();
        }
    }
}

class SmileNode {

    private String name;

    private Integer id;

    private SmileNode leftNode;

    private SmileNode rightNode;

    public SmileNode(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public SmileNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(SmileNode leftNode) {
        this.leftNode = leftNode;
    }

    public SmileNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(SmileNode rightNode) {
        this.rightNode = rightNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void preOrder() {
        System.out.println(this);

        if (null != this.getLeftNode()) {
            this.leftNode.preOrder();
        }
        if (null != this.getRightNode()) {
            this.rightNode.preOrder();
        }
    }


    public SmileNode preSearch(int id) {
        System.out.println("查询次数加一");
        if (this.getId() == id) {
            return this;
        }

        SmileNode resNode = null;
        if (null != this.getLeftNode()) {
            resNode = this.leftNode.preSearch(id);
        }
        if (null != resNode) {
            return resNode;
        }
        if (null != this.getRightNode()) {
            resNode = this.rightNode.preSearch(id);
        }

        return resNode;
    }


    public SmileNode infixSearch(int id) {
        System.out.println("查询次数加一");
        SmileNode resNode = null;
        if (null != this.getLeftNode()) {
            resNode = this.leftNode.infixSearch(id);
        }
        if (null != resNode) {
            return resNode;
        }


        if (this.getId() == id) {
            return this;
        }


        if (null != this.getRightNode()) {
            resNode = this.rightNode.infixSearch(id);
        }

        return resNode;
    }


    public SmileNode postSearch(int id) {

        SmileNode resNode = null;
        if (null != this.getLeftNode()) {
            resNode = this.leftNode.postSearch(id);
        }
        if (null != resNode) {
            return resNode;
        }


        if (null != this.getRightNode()) {
            resNode = this.rightNode.postSearch(id);
        }
        if (null != resNode) {
            return resNode;
        }
        System.out.println("查询次数加一");
        if (this.getId() == id) {
            return this;
        }

        return null;
    }


    public void infixOrder() {

        if (null != this.getLeftNode()) {
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if (null != this.getRightNode()) {
            this.rightNode.infixOrder();
        }
    }

    public void postOrder() {

        if (null != this.getLeftNode()) {
            this.leftNode.postOrder();
        }
        if (null != this.getRightNode()) {
            this.rightNode.postOrder();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SmileNode.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
