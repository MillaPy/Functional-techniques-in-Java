import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class reply2 extends ObjectOutputStream implements Serializable {
    private String code;
    private List<Book> books;


    public void Reply() {
        this.books = new ArrayList<>();
    }

    Consumer<String> setCode = code -> this.code = code;
    Supplier<String> getCode = () -> code;

    final Function<String, String> reply =
            code -> this.code = code;

    final Function<List<Book>, Book> SetAndGetBook =
            books -> (Book) (this.books = books);

    public List<Book> getBooks() {
        return books;
    }

    public reply2(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    public String toString() {
        return "Reply{" +
                "code='" + code + '\'' +
                ", books=" + books +
                '}';
    }


    enum replyOutcome {
        ADD, STOP, SHOW_ALL_BOOKS, NOT_SUCESSFULL, SUCCESSFUL
    }


}
