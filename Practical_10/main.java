import java.util.ArrayList;
import java.util.List;

class IssueException extends Exception {
    public IssueException(String message) {
        super(message);
    }
}

interface Borrowable {
    void borrowItem() throws IssueException;
    void returnItem();
}

abstract class LibraryItem {
    private int id;
    private String title;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getItemType();

    public void display() {
        System.out.println(getItemType() + " [ID=" + id + ", Title=" + title + "]");
    }
}

class Book extends LibraryItem implements Borrowable {
    private boolean issued;

    public Book(int id, String title) {
        super(id, title);
        this.issued = false;
    }

    public String getItemType() {
        return "Book";
    }

    public void borrowItem() throws IssueException {
        if (issued) {
            throw new IssueException("Book is already issued");
        }
        issued = true;
    }

    public void returnItem() {
        issued = false;
    }
}

class Magazine extends LibraryItem implements Borrowable {
    private boolean issued;

    public Magazine(int id, String title) {
        super(id, title);
        this.issued = false;
    }

    public String getItemType() {
        return "Magazine";
    }

    public void borrowItem() throws IssueException {
        if (issued) {
            throw new IssueException("Magazine is already issued");
        }
        issued = true;
    }

    public void returnItem() {
        issued = false;
    }
}

class ItemRepository<T extends LibraryItem> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }
}

class HistoryStack {
    private String[] logs = new String[10];
    private int top = -1;

    public void push(String entry) {
        if (top < logs.length - 1) {
            logs[++top] = entry;
        }
    }

    public String pop() {
        if (top == -1) {
            return "No history";
        }
        return logs[top--];
    }
}

class LibrarySystem {
    private ItemRepository<LibraryItem> repository;
    private HistoryStack history;

    public LibrarySystem() {
        repository = new ItemRepository<>();
        history = new HistoryStack();
    }

    public void addItem(LibraryItem item) {
        repository.add(item);
        history.push("Added: " + item.getTitle());
    }

    public void issueItem(Borrowable item, String title) {
        try {
            item.borrowItem();
            history.push("Issued: " + title);
            System.out.println("Successfully issued " + title);
        } catch (IssueException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showItems() {
        for (LibraryItem item : repository.getAll()) {
            item.display();
        }
    }

    public void showLastAction() {
        System.out.println("Last Action: " + history.pop());
    }
}

public class Practical10 {
    public static void main(String[] args) {
        LibrarySystem lib = new LibrarySystem();
        Book b1 = new Book(101, "Java Basics");
        Magazine m1 = new Magazine(202, "Tech Monthly");

        lib.addItem(b1);
        lib.addItem(m1);
        lib.showItems();

        lib.issueItem(b1, b1.getTitle());
        lib.issueItem(b1, b1.getTitle());
        lib.showLastAction();
    }
}
