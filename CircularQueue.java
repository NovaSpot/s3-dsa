import java.util.Scanner;

public class CircularQueue {

    int size;
    int[] queue;
    int front;
    int rear;

    // Constructor
    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];

        front = -1;
        rear = -1;
    }

    // Insert customer token
    void enqueue(int token) {

        // Check if queue is full
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full. No waiting position available.");
            return;
        }

        // First element
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = token;

        System.out.println("Token " + token + " added successfully.");
    }

    // Serve customer
    void dequeue() {

        if (front == -1) {
            System.out.println("Queue is empty. No customer to serve.");
            return;
        }

        System.out.println("Serving customer with token: " + queue[front]);

        // Only one customer
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Display waiting customers
    void display() {

        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\nCustomers currently waiting:");

        int i = front;

        while (true) {

            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of waiting positions: ");
        int size = sc.nextInt();

        CircularQueue queue = new CircularQueue(size);

        int choice;
        int token;

        do {

            System.out.println("\n===== BANK TOKEN SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. Display Waiting Customers");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter token number: ");
                    token = sc.nextInt();

                    queue.enqueue(token);
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

