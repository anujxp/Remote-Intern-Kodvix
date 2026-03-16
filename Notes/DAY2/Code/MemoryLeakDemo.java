import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDemo {

    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {

            Object obj = new Object();

            list.add(obj); // reference retained

            System.out.println("Objects stored: " + list.size());

        }

    }
}