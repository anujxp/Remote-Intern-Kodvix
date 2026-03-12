import java.util.ArrayList;
import java.util.List;

public class HeapStructureDemo {

    public static void main(String[] args) throws InterruptedException {

        List<byte[]> memoryConsumer = new ArrayList<>();

        while (true) {

            
            byte[] block = new byte[1024 * 1024];   // creating 1MB object

            memoryConsumer.add(block);

            System.out.println("Created object: " + memoryConsumer.size());

            Thread.sleep(1000);
        }
    }
}