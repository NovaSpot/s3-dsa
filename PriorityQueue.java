import java.util.Scanner;

public class PriorityQueue {

    // Patient class
    static class Patient {
        int patientId;
        String name;
        int priority;

        Patient(int patientId, String name, int priority) {
            this.patientId = patientId;
            this.name = name;
            this.priority = priority;
        }
    }

    Patient[] queue;
    int count;

    // Constructor
    PriorityQueue(int size) {
        queue = new Patient[size];
        count = 0;
    }

    // Insert patient
    void insert(int patientId, String name, int priority) {

        if (count == queue.length) {
            System.out.println("Priority queue is full.");
            return;
        }

        queue[count] = new Patient(patientId, name, priority);
        count++;

        System.out.println("Patient inserted successfully.");
    }

    // Find highest priority patient
    int findHighestPriority() {

        int highest = 0;

        for (int i = 1; i < count; i++) {

            if (queue[i].priority > queue[highest].priority) {
                highest = i;
            }
        }

        return highest;
    }

    // Delete highest priority patient
    void delete() {

        if (count == 0) {
            System.out.println("No patients waiting.");
            return;
        }

        int highest = findHighestPriority();

        System.out.println("\nPatient being treated:");
        System.out.println("Patient ID : " + queue[highest].patientId);
        System.out.println("Name       : " + queue[highest].name);
        System.out.println("Priority   : " + queue[highest].priority);

        // Shift elements
        for (int i = highest; i < count - 1; i++) {
            queue[i] = queue[i + 1];
        }

        queue[count - 1] = null;
        count--;

        System.out.println("Patient removed from queue.");
    }

    // Display highest priority patient
    void displayHighestPriority() {

        if (count == 0) {
            System.out.println("No patients waiting.");
            return;
        }

        int highest = findHighestPriority();

        System.out.println("\nHighest Priority Patient:");
        System.out.println("Patient ID : " + queue[highest].patientId);
        System.out.println("Name       : " + queue[highest].name);
        System.out.println("Priority   : " + queue[highest].priority);
    }

    // Display all patients
    void displayAll() {

        if (count == 0) {
            System.out.println("No patients waiting.");
            return;
        }

        System.out.println("\n===== PATIENTS WAITING =====");

        for (int i = 0; i < count; i++) {

            System.out.println(
                "Patient ID : " + queue[i].patientId
                + ", Name : " + queue[i].name
                + ", Priority : " + queue[i].priority
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of patients: ");
        int size = sc.nextInt();

        PriorityQueue pq = new PriorityQueue(size);

        int choice;

        do {

            System.out.println("\n===== EMERGENCY ROOM =====");
            System.out.println("1. Insert Patient");
            System.out.println("2. Treat/Delete Highest Priority Patient");
            System.out.println("3. Display Highest Priority Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Priority Number: ");
                    int priority = sc.nextInt();

                    pq.insert(id, name, priority);

                    break;

                case 2:
                    pq.delete();
                    break;

                case 3:
                    pq.displayHighestPriority();
                    break;

                case 4:
                    pq.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

