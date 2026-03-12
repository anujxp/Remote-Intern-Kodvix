public class G1GCDemo {

    public static void main(String[] args) {

        while (true) {

            for (int i = 0; i < 1000; i++) {

                String temp = new String("Garbage Object " + i);

            }

        }

    }
}
// run with.....................
// java -XX:+UseG1GC -Xlog:gc G1GCDemo