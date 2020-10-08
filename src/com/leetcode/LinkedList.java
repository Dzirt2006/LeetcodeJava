package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

class NodeList {
    public int val;
    public NodeList next;

    public NodeList(int value) {
        this.val = value;
    }
}

public class LinkedList {

}

class LLLeetcode {

    /**
     * N. 237
     * Write a function to delete a node in a singly-linked list.
     * You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
     *
     * @param node
     */
    public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * N. 138
     * A linked list is given such that each node contains an additional
     * random pointer which could point to any node in the list or null.
     * Return a deep copy of the list.
     */
    class Node extends NodeList {
        Node next;
        Node random;

        public Node(int val) {
            super(val);
            this.next = null;
            this.random = null;
        }

        public Node copyRandomList(Node head) {
            if (head == null) return head;
            HashMap<Node, Node> indexesMap = new HashMap<Node, Node>();
            Node runner = head;
            Node newCopy = new Node(head.val);
            Node copyRunner = newCopy;
            while (runner.next != null) {
                copyRunner.next = new Node(runner.next.val);
                indexesMap.put(runner, copyRunner);
                copyRunner = copyRunner.next;
                runner = runner.next;
            }
            indexesMap.put(runner, copyRunner);
            copyRunner = newCopy;
            runner = head;
            System.out.println();
            while (copyRunner != null) {
                if (runner.random != null) {
                    copyRunner.random = indexesMap.get(runner.random);
                } else {
                    copyRunner.random = null;
                }
                copyRunner = copyRunner.next;
                runner = runner.next;
            }
            return newCopy;
        }
    }
}



















