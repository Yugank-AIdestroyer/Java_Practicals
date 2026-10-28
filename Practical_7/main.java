import java.util.ArrayList;
import java.util.List;

class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void showPair() {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}

public class Practical7 {
    public static <T> void printItem(T item) {
        System.out.println("Item: " + item);
    }

    public static <T extends Number> double square(T number) {
        return number.doubleValue() * number.doubleValue();
    }

    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum = sum + n.doubleValue();
        }
        return sum;
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics");
        System.out.println(strBox.get());

        Pair<Integer, String> pair = new Pair<>(1, "One");
        pair.showPair();

        printItem(100);
        printItem("Java");
        System.out.println("Square: " + square(5));

        List<Double> doubles = new ArrayList<>();
        doubles.add(2.5);
        doubles.add(3.5);
        System.out.println("Sum: " + sumNumbers(doubles));

        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println("Super list size: " + numbers.size());
    }
}
