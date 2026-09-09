import java.util.Scanner;

class SongNode {
    String songName;
    SongNode prev, next;

    SongNode(String songName) {
        this.songName = songName;
    }
}

class MP3Player {
    SongNode head, tail, current;

    // Add a song at the end of the playlist
    void addSong(String songName) {
        SongNode newNode = new SongNode(songName);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Song \"" + songName + "\" added to playlist.");
    }

    // Delete a song from the playlist
    void deleteSong(String songName) {
        SongNode temp = head;
        while (temp != null) {
            if (temp.songName.equals(songName)) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;

                if (current == temp)
                    current = (temp.next != null) ? temp.next : temp.prev;

                System.out.println("Song \"" + songName + "\" deleted from playlist.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Song \"" + songName + "\" not found.");
    }

    // Display all songs in forward direction
    void displayForward() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.print("Playlist (forward): ");
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.songName + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Display all songs in backward direction
    void displayBackward() {
        if (tail == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.print("Playlist (backward): ");
        SongNode temp = tail;
        while (temp != null) {
            System.out.print(temp.songName + " -> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    // Move to the next song
    void moveNext() {
        if (current == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (current.next != null) {
            current = current.next;
            System.out.println("Now playing: " + current.songName);
        } else {
            System.out.println("Already at the last song: " + current.songName);
        }
    }

    // Move to the previous song
    void movePrevious() {
        if (current == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Now playing: " + current.songName);
        } else {
            System.out.println("Already at the first song: " + current.songName);
        }
    }
}

public class MP3PlayerApp {
    public static void main(String[] args) {
        MP3Player player = new MP3Player();
        Scanner sc = new Scanner(System.in);
        int choice;
        String songName;

        while (true) {
            System.out.println("\n--- MP3 Player ---");
            System.out.println("1. Add song at end");
            System.out.println("2. Delete song");
            System.out.println("3. Display forward");
            System.out.println("4. Display backward");
            System.out.println("5. Move to next song");
            System.out.println("6. Move to previous song");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add: ");
                    songName = sc.next();
                    player.addSong(songName);
                    break;
                case 2:
                    System.out.print("Enter song name to delete: ");
                    songName = sc.next();
                    player.deleteSong(songName);
                    break;
                case 3:
                    player.displayForward();
                    break;
                case 4:
                    player.displayBackward();
                    break;
                case 5:
                    player.moveNext();
                    break;
                case 6:
                    player.movePrevious();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
