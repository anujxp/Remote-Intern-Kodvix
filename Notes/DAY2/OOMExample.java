import java.util.ArrayList;

public class OOMExample {

    public static void main(String[] args) {

        ArrayList<int[]> list = new ArrayList<>();

        while (true) {

            list.add(new int[1000000]);

        }

    }
}

// run with small heap
// java -Xmx32m OOMExample