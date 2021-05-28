import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.List.*;

public class ClientHandler extends Thread {

    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private List<Book> books;

    final BiFunction<Socket, List<Book>, Predicate<Socket>> clientHandling = (socket, books) -> {
      this.socket = socket;
      try{
          this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
          this.objectInputStream = new ObjectInputStream(socket.getInputStream());
      } catch (IOException e) {
          e.printStackTrace();
      }
      this.books = books;
      return null;
    };


    @Override
    public void run() {
        label:
        while (true) {

            Optional<Request> readObject;
            try {
                Request request = null;
                readObject = Optional
                        .ofNullable(request)
                        .map((Request ret) -> {
                                    try {
                                        objectInputStream.readObject();
                                    } catch (ClassNotFoundException | IOException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                }
                        );} catch (RuntimeException e){
                throw e;
            }

                Function<ObjectOutputStream, reply2> exception = reply -> {
                    try {
                        objectOutputStream.writeObject(reply);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                };


                Function<reply2, List<Book>> showbooks = (reply) -> {
                    books.forEach(b -> {
                        books.add(new Book(b));
                        reply.SetAndGetBook.apply(Collections.singletonList(new Book(b)));
                    });
                    exception.apply(reply);
                    reply2.replyOutcome.SHOW_ALL_BOOKS.equals("Show the books!");
                    return null;
                };

                Function<reply2, List<Book>> addbooks = (reply) -> {
                    Request req = null;
                    books.add(req.getBook());
                    exception.apply(reply);
                    reply2.replyOutcome.ADD.equals("Successfully added!");
                    return null;

                };

                Function<reply2, List<Book>> stopProcess = (reply) -> {
                    try {
                        reply.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    reply2.replyOutcome.STOP.equals("Stop the process!");
                    return null;
                };

                Request request = null;
                switch(request.getCode()){
                        case "SHOW_ALL_BOOKS":{
                            showbooks.apply((reply2) books);
                            break;
                        }
                        case "Add": {
                            addbooks.apply((reply2) books);
                            break;
                        }
                        case "Stop": {
                            //stopProcess.apply((reply2) books);
                            break label;
                        }
                    default:
                        throw new IllegalStateException("Unexpected value: " + request.getCode());
                }

        }
    }
}











/// old code


    /*

                Map<String, List<Book>> switchCases = new HashMap<String, List<Book>>();
                switchCases.put("Show all books",
                        showbooks.apply((reply2) books));
                switchCases.put("Stop",
                        stopProcess.apply((reply2) books));
                switchCases.put("Add",
                        addbooks.apply((reply2) books));
    public ClientHandler(Socket socket,  List<Book> books) {
        this.socket = socket;
        try {
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.books = books;


        switch (request.getCode()) {
                case "ShowAllBooks": {
                    Reply reply = new Reply();
                    ArrayList<Book> replyBooks = new ArrayList<>();
                    for (Book b : books) {
                        replyBooks.add(new Book(b));
                    }
                    reply.setBooks(replyBooks);
                    try {
                        objectOutputStream.writeObject(reply);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ADD": {
                    books.add(request.getBook());
                    Reply reply = new Reply("Added successfully!!!");
                    try {
                        objectOutputStream.writeObject(reply);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Stop":
                    break label;
            }
        }
    }*

     Function<ObjectOutputStream, reply2> exception = reply -> {
                 try {
                   objectOutputStream.writeObject(reply);
                } catch (IOException e) {
                     e.printStackTrace();
                }
                 retu
            };/
     */

//functional approach


           /* Request request = null;
            try {
                request = (Request) objectInputStream.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }*/