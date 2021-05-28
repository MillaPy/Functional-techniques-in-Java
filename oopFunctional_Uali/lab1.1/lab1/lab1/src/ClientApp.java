import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1999);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("You successfully entered");

            Scanner scanner = new Scanner(System.in);



            while (true) {
                System.out.println("1. Show all books");
                System.out.println("2. Add new book");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    Request request = new Request("SHOW_ALL_BOOKS");
                    objectOutputStream.writeObject(request);

                    reply2 reply = (reply2) objectInputStream.readObject();

                    List<Book> books = reply.getBooks();

                    //List<Book> books = (List<Book>) reply.SetAndGetBook.andThen(Book::new);
                    for (Book b : books) {
                        System.out.println("All books: \n" + b);
                    }
                } else if (choice == 2) {
                    System.out.println("Input the name of the book: ");
                    String name = scanner.next();
                    System.out.println("Input the author of the book: ");
                    String author = scanner.next();

                    Book book = new Book(null, name, author);
                    Request request = new Request("ADD", book);

                    objectOutputStream.writeObject(request);

                    reply2 reply = (reply2) objectInputStream.readObject();
                    System.out.println(reply.getBooks());
                    System.out.println("Successfully added!");
                } else if (choice == 0) {
                    Request request = new Request("STOP");
                    objectOutputStream.writeObject(request);

                    break;
                }
            }

            objectInputStream.close();
            objectOutputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
