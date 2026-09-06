import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Insert a node at the end
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Display the list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // a) Find and display the Nth node from the end
    void findNthFromEnd(int n) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (n <= 0 || n > length) {
            System.out.println("Invalid value of N");
            return;
        }

        int posFromStart = length - n; // 0-based index from start
        temp = head;
        for (int i = 0; i < posFromStart; i++) {
            temp = temp.next;
        }

        System.out.println(n + "th node from the end is: " + temp.data);
    }

    // b) Remove duplicates from an unsorted linked list
    void removeDuplicates() {
        if (head == null) return;

        Set<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next; // skip duplicate node
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }
}

public class LinkedListOps {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Sample data (with duplicates)
        int[] values = {10, 20, 30, 20, 40, 10, 50};
        for (int v : values) {
            list.insert(v);
        }

        System.out.println("Original list:");
        list.display();

        // a) Nth node from the end
        int n = 3;
        list.findNthFromEnd(n);

        // b) Remove duplicates
        list.removeDuplicates();
        System.out.println("List after removing duplicates:");
        list.display();
    }
}
