package src.com.leetcode;

public class LinkedListAlgoExpert {
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList main;
        LinkedList swap;
        if (headOne.value <= headTwo.value) {
            main = headOne;
            swap = headTwo;
        } else {
            main = headTwo;
            swap = headOne;
        }
        LinkedList pointer = main.next;
        LinkedList newHead = main;
        while (main != null && swap != null) {

            if (main.value <= swap.value) {
                pointer = main;
                main = main.next;
            } else {
                pointer.next = swap;
                swap = swap.next;
                pointer = pointer.next;
                pointer.next = main;
            }

        }
        if (swap != null) {
            pointer.next = swap;
        }

        return newHead;
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}

class ListRunner {
    public static void main(String[] args) {
        LinkedListAlgoExpert.LinkedList list1 = new LinkedListAlgoExpert.LinkedList(2);//2-5-7-8
        LinkedListAlgoExpert.LinkedList list2 = new LinkedListAlgoExpert.LinkedList(1);//1-3-4-6
        list1.next = new LinkedListAlgoExpert.LinkedList(5);
        list1.next.next = new LinkedListAlgoExpert.LinkedList(7);
        list1.next.next.next = new LinkedListAlgoExpert.LinkedList(8);
        list2.next = new LinkedListAlgoExpert.LinkedList(3);
        list2.next.next = new LinkedListAlgoExpert.LinkedList(4);
        list2.next.next.next = new LinkedListAlgoExpert.LinkedList(6);
        LinkedListAlgoExpert.mergeLinkedLists(list1, list2);
    }
}