public class MyHeap {
    private int length;
    private int[] p;

    public MyHeap(int[] p) {
        length = p.length;
        this.p = p;
    }

    /**
     * 讨论 heap 时，一般认为是从 1 开始计数的，有 index 做从 heap 的 index 到实际 array 的 下标的转换
     *
     * @param i
     * @return
     */
    private int get(int i) {
        return p[i - 1];
    }

    private void set(int i, int value) {
        p[i - 1] = value;
    }

    private void swap(int i, int j) {
        int temp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, temp);
    }

    public static int left(int parentIndex) {
        return 2 * parentIndex;
    }

    public static int right(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public static int parent(int childIndex) {
        int parentIndex = childIndex / 2;
        return parentIndex;
    }

    public static void maxHeaplify(MyHeap myHeap, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= myHeap.length && myHeap.get(l) > myHeap.get(i)) {
            largest = l;
        } else {
            largest = i;
        }

        if (r <= myHeap.length && myHeap.get(r) > myHeap.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            myHeap.swap(largest, i);
            maxHeaplify(myHeap, largest);
        }
    }

    public void buildMaxHeap() {
        int temp = this.length / 2;
        for (int i = temp; i >= 1; i--) {
            maxHeaplify(this, i);
        }
    }

    public boolean equals(MyHeap other) {
        if (this.length == other.length) {
            for (int i = 1; i < this.length; i++) {
                if (this.get(i) != other.get(i)) {
                    return false;
                }

            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isMaxHeap() {
        int temp = this.length / 2;
        for (int i = 1; i <= temp; i++) {
            int left = left(i);
            if (left <= this.length && this.get(left) > this.get(i)) {
                return false;
            }

            int right = right(i);
            if (right <= this.length && this.get(right) > this.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void heapSort() {
        buildMaxHeap();
        int length = this.length;
        for (int i = this.length; i >= 2; i--) {
            swap(1, i);
            this.length = this.length - 1;
            maxHeaplify(this, 1);
        }
        // 这一句是我添的，因为我觉得一个 array 经过 heapSort 之后，length 应当保持不变
        this.length = length;
    }

    public boolean isSorted() {
        for (int i = 1; i < this.length; i++) {
            if (this.get(i) > this.get(i + 1)) {
                return false;
            }
        }
        return true;

    }
}
