import java.util.Scanner;

public class VehicleDeque {

    String[] deque;
    int front;
    int rear;
    int size;

    // Constructor
    VehicleDeque(int size) {
        this.size = size;

        deque = new String[size];

        front = -1;
        rear = -1;
    }

    // Add normal vehicle at rear
    void addNormalVehicle(String vehicle) {

        if (rear == size - 1) {
            System.out.println("Deque is full at rear.");
            return;
        }

        // First vehicle
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear++;
        }

        deque[rear] = vehicle;

        System.out.println("Normal vehicle added at rear.");
    }

    // Add emergency vehicle at front
    void addEmergencyVehicle(String vehicle) {

        // No space at front
        if (front == 0) {
            System.out.println("No space available at front.");
            return;
        }

        // First vehicle
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            front--;
        }

        deque[front] = vehicle;

        System.out.println("Emergency vehicle added at front.");
    }

    // Dispatch vehicle from front
    void dispatchFromFront() {

        if (front == -1) {
            System.out.println("No vehicles waiting.");
            return;
        }

        System.out.println("Vehicle dispatched: " + deque[front]);

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
    }

    // Cancel vehicle from rear
    void cancelFromRear() {

        if (rear == -1) {
            System.out.println("No vehicles waiting.");
            return;
        }

        System.out.println("Vehicle cancelled: " + deque[rear]);

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear--;
        }
    }

    // Display all vehicles
    void display() {

        if (front == -1) {
            System.out.println("No vehicles waiting.");
            return;
        }

        System.out.println("\n===== VEHICLES WAITING =====");

        for (int i = front; i <= rear; i++) {
            System.out.println(deque[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter deque size: ");
        int size = sc.nextInt();

        sc.nextLine();

        VehicleDeque dq = new VehicleDeque(size);

        int choice;

        do {

            System.out.println("\n===== EMERGENCY VEHICLE SERVICE =====");
            System.out.println("1. Add Normal Vehicle");
            System.out.println("2. Add Emergency Vehicle");
            System.out.println("3. Dispatch Vehicle from Front");
            System.out.println("4. Cancel Vehicle from Rear");
            System.out.println("5. Display Vehicles");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter normal vehicle name: ");
                    String normalVehicle = sc.nextLine();

                    dq.addNormalVehicle(normalVehicle);

                    break;

                case 2:

                    System.out.print("Enter emergency vehicle name: ");
                    String emergencyVehicle = sc.nextLine();

                    dq.addEmergencyVehicle(emergencyVehicle);

                    break;

                case 3:

                    dq.dispatchFromFront();

                    break;

                case 4:

                    dq.cancelFromRear();

                    break;

                case 5:

                    dq.display();

                    break;

                case 6:

                    System.out.println("Exiting...");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}

