
class OverFlow extends Exception {
    @Override
    public String toString() {
        return "OverFlow";
    }
}

class UnderFlow extends Exception {
    @Override
    public String toString() {
        return "UnderFlow";
    }
}


public class MyStack {
    private int top;
    private int[] s;

    /**
     * 直接把指针付给 this.s 方便重用一个 array。
     * @param n
     * @param s
     */
    MyStack(int n, int[] s) {
        this.s = s;
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public void push(int x) throws OverFlow {
        try {
            this.top += 1;
            this.s[this.top] = x;
        } catch (IndexOutOfBoundsException e) {
            throw new OverFlow();
        }
    }

    public int pop() throws UnderFlow {
        if (isEmpty()) {
            throw new UnderFlow();
        } else {
            this.top = this.top - 1;
            return this.s[this.top + 1];
        }
    }
}