class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericLinkedList<T> {
    private Node<T> head;
    private int count;

    public GenericLinkedList() {
        head = null;
        count = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return count;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;
    }

    public void delete(T key) {
        if (head == null) {
            return;
        }
        if (head.data.equals(key)) {
            head = head.next;
            count--;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(key)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            count--;
        }
    }

    public boolean search(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void traverse() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Practical9 {
    public static void main(String[] args) {
        GenericLinkedList<Integer> intList = new GenericLinkedList<>();
        intList.insert(10);
        intList.insert(20);
        intList.insert(30);
        intList.traverse();
        intList.delete(20);
        System.out.println("Search 30: " + intList.search(30) + ", Size: " + intList.size());

        GenericLinkedList<String> strList = new GenericLinkedList<>();
        strList.insert("Apple");
        strList.insert("Mango");
        strList.traverse();
        System.out.println("Empty: " + strList.isEmpty() + ", Size: " + strList.size());
    }
}
