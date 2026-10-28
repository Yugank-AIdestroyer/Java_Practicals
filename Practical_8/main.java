class IntStack {
    private int[] arr;
    private int top;
    private int capacity;

    public IntStack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }
}

class IntQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public IntQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }
}

public class Practical8 {
    public static void main(String[] args) {
        IntStack stack = new IntStack(2);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack Peek: " + stack.peek());
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Pop: " + stack.pop());
        stack.pop();

        IntQueue queue = new IntQueue(2);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println("Queue Front: " + queue.front());
        System.out.println("Queue Dequeue: " + queue.dequeue());
        System.out.println("Queue Dequeue: " + queue.dequeue());
        queue.dequeue();
    }
}
