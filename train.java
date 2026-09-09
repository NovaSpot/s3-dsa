import java.util.Scanner;

class CoachNode {
    int coachNumber;
    CoachNode prev, next;

    CoachNode(int coachNumber) {
        this.coachNumber = coachNumber;
    }
}

class TrainCoachDLL {
    CoachNode head, tail;

    // Add a coach at the beginning
    void addAtBeginning(int coachNumber) {
        CoachNode newNode = new CoachNode(coachNumber);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Coach " + coachNumber + " added at the beginning.");
    }

    // Remove a coach using coach number
    void removeCoach(int coachNumber) {
        CoachNode temp = head;
        while (temp != null) {
            if (temp.coachNumber == coachNumber) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;

                System.out.println("Coach " + coachNumber + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Coach " + coachNumber + " not found.");
    }

    // Display all coaches from last coach towards engine (i.e., tail to head)
    void displayFromLastToEngine() {
        if (tail == null) {
            System.out.println("No coaches attached.");
            return;
        }
        System.out.print("Coaches (last -> engine): ");
        CoachNode temp = tail;
        while (temp != null) {
            System.out.print(temp.coachNumber + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Search for a particular coach
    void search(int coachNumber) {
        CoachNode temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.coachNumber == coachNumber) {
                System.out.println("Coach " + coachNumber + " found at position " + position + " from engine.");
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Coach " + coachNumber + " not found.");
    }
}

public class TrainCoachManagement {
    public static void main(String[] args) {
        TrainCoachDLL train = new TrainCoachDLL();
        Scanner sc = new Scanner(System.in);
        int choice, coachNumber;

        while (true) {
            System.out.println("\n--- Train Coach Management ---");
            System.out.println("1. Add coach at beginning");
            System.out.println("2. Remove coach by number");
            System.out.println("3. Display from last coach to engine");
            System.out.println("4. Search coach");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter coach number to add: ");
                    coachNumber = sc.nextInt();
                    train.addAtBeginning(coachNumber);
                    break;
                case 2:
                    System.out.print("Enter coach number to remove: ");
                    coachNumber = sc.nextInt();
                    train.removeCoach(coachNumber);
                    break;
                case 3:
                    train.displayFromLastToEngine();
                    break;
                case 4:
                    System.out.print("Enter coach number to search: ");
                    coachNumber = sc.nextInt();
                    train.search(coachNumber);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
