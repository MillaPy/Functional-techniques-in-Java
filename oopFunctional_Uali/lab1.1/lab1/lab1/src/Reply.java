import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reply implements Serializable {

    private String code;
  //  private ArrayList<Book> books;
    private List<Book> books = List.of();

    public Reply() {
        books = new ArrayList<>();
    }

    public Reply(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "code='" + code + '\'' +
                ", books=" + books +
                '}';
    }
}
