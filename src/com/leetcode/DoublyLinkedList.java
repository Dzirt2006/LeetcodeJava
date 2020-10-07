package com.leetcode;

import java.util.*;


class DoublyLinkedList {
    static class DLL {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (this.head != null) {
                Node pointer = this.head;
                this.head = node;
                pointer.prev = this.head;
                this.head.next = pointer;
                if (this.tail == null) {
                    this.tail = pointer;
                }
            } else {
                this.head = node;
                this.tail = node;
            }
        }

        public void setTail(Node node) {
            if (this.tail != null) {
                Node pointer = this.tail;
                this.tail = node;
                pointer.next = this.tail;
                this.tail.prev = pointer;
            } else {
                this.tail = node;
                this.tail.prev = this.head;
                this.head.next = this.tail;
            }
        }

        public void insertBefore(Node node, Node nodeToMove) { //move existing node to position before
            Node prev;
            Node next;
            if (nodeToMove.equals(this.head)) {
                this.head = nodeToMove.next;
                this.head.prev = null;
            } else if (nodeToMove.equals(this.tail)) {
                this.tail = nodeToMove.prev;
                this.tail.next = null;
            } else {
                //set the pointers to prev and next nodes
                prev = nodeToMove.prev;
                next = nodeToMove.next;
                //cut the node from the chain
                prev.next = next;
                next.prev = prev;
            }
            //insert node
            if (node.equals(this.head)) {
                this.head.prev = nodeToMove;
                this.head = nodeToMove;
                this.head.prev = null;
            } else if (node.equals(this.tail)) {
                this.tail.next = nodeToMove;
                nodeToMove.prev = this.tail;
                this.tail = nodeToMove;
                this.tail.next = null;
            } else {
                prev = node.prev;
                nodeToMove.next = node;
                nodeToMove.prev = prev;
                prev.next = nodeToMove;
            }

        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
        }

        public void remove(Node node) {
            // Write your code here.
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            return false;
        }

        public Node noder(int val) {
            Node pointer = this.head;
            while (pointer != null) {
                if (pointer.value == val) {
                    return pointer;
                }
                pointer = pointer.next;
            }
            return null;
        }
        public int[] listVisualising(){
            Node pointer = this.head;
            List<Integer> res=new ArrayList<>();
            while (pointer != null) {
                res.add(pointer.value);
                pointer = pointer.next;
            }
            int[] array = res.stream().mapToInt(i->i).toArray();
            return array;
        }
    }

    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}


class Runner {
    public static void main(String[] args) {
        DoublyLinkedList.DLL dll = new DoublyLinkedList.DLL();
        dll.setHead(new DoublyLinkedList.Node(5));
        dll.setTail(new DoublyLinkedList.Node(10));
        dll.setHead(new DoublyLinkedList.Node(1));
        dll.setTail(new DoublyLinkedList.Node(106885));
        System.out.println(Arrays.toString(dll.listVisualising()));
        dll.insertBefore(dll.noder(106885), dll.noder(1));
        System.out.println(Arrays.toString(dll.listVisualising()));
    }
}
































