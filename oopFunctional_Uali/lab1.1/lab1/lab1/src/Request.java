import java.io.Serializable;

public class Request implements Serializable {

    private String code;
    private Book book;
    private Long id;

    public Request() {}

    public Request(String code) {
        this.code = code;
    }

    public Request(String code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Request(String code, Long id) {
        this.code = code;
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Request{" +
                "code='" + code + '\'' +
                ", book=" + book +
                ", id=" + id +
                '}';
    }
}
