import java.util.Scanner;

// Definisi class Node untuk merepresentasikan node dalam LinkedList
class Node {
    String bookTitle;
    Node next;

    // Constructor untuk membuat node baru dengan judul buku tertentu
    Node(String bookTitle) {
        this.bookTitle = bookTitle;
        this.next = null;
    }
}

// Definisi class LinkedList
class LinkedList {
    Node head;  // Head (elemen pertama) dari LinkedList

    // Method untuk menambahkan buku baru ke dalam daftar sewa
    void rentBook(String bookTitle) {
        Node newNode = new Node(bookTitle);  // Membuat node baru dengan judul buku
        newNode.next = head;  // Mengatur pointer next dari node baru ke head yang lama
        head = newNode;  // Mengatur head linked list ke node baru
        System.out.println("Buku '" + bookTitle + "' telah berhasil disewa.");
    }

    // Method untuk menampilkan daftar buku yang sedang disewa
    void displayRentedBooks() {
        if (head == null) {
            System.out.println("Belum ada buku yang disewa.");
            return;
        }
        System.out.println("Daftar buku yang sedang disewa:");
        Node current = head;  // Pointer untuk traversal dari head
        while (current != null) {
            System.out.println("- " + current.bookTitle);
            current = current.next;
        }
    }

    // Method untuk mencari buku berdasarkan judulnya
    void searchBook(String bookTitle) {
        Node current = head;  // Pointer untuk traversal dari head
        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Buku '" + bookTitle + "' ditemukan dalam daftar sewa.");
                return;
            }
            current = current.next;
        }
        System.out.println("Buku '" + bookTitle + "' tidak ditemukan dalam daftar sewa.");
    }
}

// Class utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList rentedBooks = new LinkedList();

        System.out.println("Selamat datang di sistem sewa buku.");

        // Menu interaktif
        while (true) {
            System.out.println("\nPilih operasi yang ingin dilakukan:");
            System.out.println("1. Sewa buku");
            System.out.println("2. Lihat daftar buku yang disewa");
            System.out.println("3. Cari buku berdasarkan judul");
            System.out.println("4. Keluar");

            System.out.print("Masukkan pilihan (1/2/3/4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Masukkan judul buku yang ingin disewa: ");
                    String bookTitle = scanner.nextLine();
                    rentedBooks.rentBook(bookTitle);
                    break;
                case "2":
                    rentedBooks.displayRentedBooks();
                    break;
                case "3":
                    System.out.print("Masukkan judul buku yang ingin dicari: ");
                    String searchTitle = scanner.nextLine();
                    rentedBooks.searchBook(searchTitle);
                    break;
                case "4":
                    System.out.println("Terima kasih telah menggunakan sistem sewa buku.");
                    return;  // Keluar dari program
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, 3, atau 4.");
            }
        }
    }
}
