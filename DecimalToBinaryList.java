import java.util.Scanner;

class BitNode {
    int bit;
    BitNode next;

    BitNode(int bit) {
        this.bit = bit;
        this.next = null;
    }
}

class BinaryLinkedList {
    BitNode head;
    BitNode tail;

    // Insert a bit at the end of the list
    void insert(int bit) {
        BitNode newNode = new BitNode(bit);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Display the binary digits stored in the list
    void display() {
        BitNode temp = head;
        while (temp != null) {
            System.out.print(temp.bit);
            temp = temp.next;
        }
        System.out.println();
    }

    // Convert decimal number into binary and store each bit in the list
    void convertToBinary(int decimal) {
        if (decimal == 0) {
            insert(0);
            return;
        }

        // Collect bits in reverse order first (using a stack-like approach)
        StringBuilder binaryStr = new StringBuilder();
        int num = decimal;
        while (num > 0) {
            binaryStr.append(num % 2);
            num = num / 2;
        }
        binaryStr.reverse(); // reverse to get correct MSB-to-LSB order

        for (int i = 0; i < binaryStr.length(); i++) {
            insert(binaryStr.charAt(i) - '0');
        }
    }
}

public class DecimalToBinaryList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();

        BinaryLinkedList binList = new BinaryLinkedList();
        binList.convertToBinary(decimal);

        System.out.print("Binary equivalent (from linked list): ");
        binList.display();

        sc.close();
    }
}
