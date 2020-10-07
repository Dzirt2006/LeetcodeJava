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
                this.tail.next = null;
            } else {
                this.tail = node;
                this.tail.prev = this.head;
                this.head.next = this.tail;
                this.tail.next = null;
            }
        }

        public void insertBefore(Node node, Node nodeToMove) { //move existing node to position before
            if(nodeToMove.next!=null || nodeToMove.prev!=null) remove(nodeToMove);
            //insert node
            if (node.equals(this.head)) {
                setHead(nodeToMove);
            } else {
                Node prev = node.prev;
                nodeToMove.next = node;
                nodeToMove.prev = prev;
                prev.next = nodeToMove;
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if(nodeToInsert.next!=null || nodeToInsert.prev!=null)  remove(nodeToInsert);
           if (node.equals(this.tail)) {
                setTail(nodeToInsert);
            } else {
                Node next = node.next;
                node.next=nodeToInsert;
                nodeToInsert.next = next;
                nodeToInsert.prev = node;
                next.prev = nodeToInsert;
            }
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            int count=1;
            Node pointer=this.head;
            while (count<position){
                    count++;
                try{
                    pointer=pointer.next;
                }catch(NullPointerException e){
                    System.out.println("Index doesn't exist");
                    break;
                }
            }
            insertBefore(pointer,nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            remove(noder(value));
        }

        public void remove(Node node) {
            if (node.equals(this.head)) {
                this.head = node.next;
                this.head.prev = null;
            } else if (node.equals(this.tail)) {
                this.tail = node.prev;
                this.tail.next = null;
            } else {
                //set the pointers to prev and next nodes
                Node prev = node.prev;
                Node next = node.next;
                //cut the node from the chain
                prev.next = next;
                next.prev = prev;
            }
        }

        public boolean containsNodeWithValue(int value) {
            return noder(value) != null;
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

        public int[] listVisualising() {
            Node pointer = this.head;
            List<Integer> res = new ArrayList<>();
            while (pointer != null) {
                res.add(pointer.value);
                pointer = pointer.next;
            }
            int[] array = res.stream().mapToInt(i -> i).toArray();
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
        dll.insertBefore(dll.noder(1), new DoublyLinkedList.Node(50320));
        System.out.println(Arrays.toString(dll.listVisualising()));
        dll.insertAfter(dll.noder(50320), new DoublyLinkedList.Node(500));
        System.out.println(Arrays.toString(dll.listVisualising()));
        dll.insertAtPosition(44, new DoublyLinkedList.Node(666));
        System.out.println(Arrays.toString(dll.listVisualising()));
        System.out.println(dll.containsNodeWithValue(1));

    }
}
































