/**
 * Created by T440P on 2017/9/26.
 */
public class MyQueue {

    private int head;
    private int tail;
    private int[] Q;

    MyQueue(int n) {
        head = 0;
        tail = 0;
        Q = new int[n];
    }

    public void enqueue(int x) {
        Q[tail] = x;
        if (tail == Q.length) {
            tail = 1;
        } else {
            tail += 1;
        }
    }

    public int dequque() {
        int x = Q[head];
        if (Q[head] == Q.length) {
            head = 1;
        } else {
            head += 1;
        }
        return x;
    }
}
