package com.hailintang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CopyListWithRandomPointer
 * @Description 复制带有随机指针的链表(AC)
 * @Author DELL
 * @Date 2019/6/19 9:57
 * @Version 1.0
 */
public class CopyListWithRandomPointer {
    /**
     * Definition for a Node.
     */
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        //判断头结点是否为空
        if(head==null){
            return null;
        }
        Map<Node,Node> nodeMap = new HashMap<>();


        //记录头指针位置
        Node node = head;
        //循环1：复制节点，不复制next指针，不复制random指针
        while (head!=null){
            nodeMap.put(head,new Node(head.val,null,null));
            head = head.next;
        }

        head = node;
        //循环2：加next指针，加random指针
        while(head!=null){
            nodeMap.get(head).next = nodeMap.get(head.next);
            nodeMap.get(head).random = nodeMap.get(head.random);
            head = head.next;
        }
        //返回复制链表的头结点
        return nodeMap.get(node);
    }


}
