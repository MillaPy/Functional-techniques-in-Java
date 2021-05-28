import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerApp {

    private ServerSocket serverSocket;
    private List<Book> books;

    public ServerApp() {
        books = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(1999);
            System.out.println("Server socket created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                System.out.println("waiting for a client...");
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler();
                clientHandler.clientHandling.apply(socket, books);
                clientHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ServerApp serverApp = new ServerApp();
        serverApp.start();
    }

}
