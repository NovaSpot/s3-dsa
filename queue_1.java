import java.util.Scanner;

public class queue_1 {

    // Node class
    static class Node {
        String job;
        Node next;

        Node(String job) {
            this.job = job;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    // Insert print job
    void enqueue(String job) {
        Node newNode = new Node(job);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Print job inserted successfully.");
    }

    // Process next print job
    void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Processing print job: " + front.job);

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    // Display all print jobs
    void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;

        System.out.println("\nPrint Jobs in Queue:");

        while (temp != null) {
            System.out.println(temp.job);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PrintQueue queue = new PrintQueue();

        int choice;
        String job;

        do {
            System.out.println("\n===== PRINT QUEUE =====");
            System.out.println("1. Insert Print Job");
            System.out.println("2. Process Next Job");
            System.out.println("3. Display Jobs");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter print job: ");
                    job = sc.nextLine();

                    queue.enqueue(job);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
