import java.util.*;

class LNode {
    int data;
    LNode next;

    LNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SLinkedList {
    LNode head;

    void insert(int data) {
        LNode newNode = new LNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        LNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void display() {
        LNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class CommonElements {

    // Find common elements between two linked lists
    static SLinkedList findCommon(SLinkedList list1, SLinkedList list2) {
        SLinkedList result = new SLinkedList();
        Set<Integer> seenInResult = new HashSet<>();

        Set<Integer> firstListElements = new HashSet<>();
        LNode temp1 = list1.head;
        while (temp1 != null) {
            firstListElements.add(temp1.data);
            temp1 = temp1.next;
        }

        LNode temp2 = list2.head;
        while (temp2 != null) {
            if (firstListElements.contains(temp2.data) && !seenInResult.contains(temp2.data)) {
                result.insert(temp2.data);
                seenInResult.add(temp2.data);
            }
            temp2 = temp2.next;
        }

        return result;
    }

    public static void main(String[] args) {
        SLinkedList list1 = new SLinkedList();
        int[] values1 = {10, 20, 30, 40, 50};
        for (int v : values1) list1.insert(v);

        SLinkedList list2 = new SLinkedList();
        int[] values2 = {30, 40, 50, 60, 70};
        for (int v : values2) list2.insert(v);

        System.out.println("List 1:");
        list1.display();

        System.out.println("List 2:");
        list2.display();

        SLinkedList common = findCommon(list1, list2);
        System.out.println("Common elements:");
        common.display();
    }
}
