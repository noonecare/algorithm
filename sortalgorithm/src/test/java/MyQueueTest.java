import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

/**
 * Created by T440P on 2017/9/26.
 */
public class MyQueueTest {
    @Test
    public void enqueue() throws Exception {
        int a[] = new int[10];
        Random random = new Random();
        MyQueue myQueue = new MyQueue(10);

        for (int i=0;i<a.length;i++) {
            a[i] = random.nextInt();
            myQueue.enqueue(a[i]);
            assert(myQueue.dequque() == a[i]);
        }
    }

    @Test
    public void dequque() throws Exception {
    }

}