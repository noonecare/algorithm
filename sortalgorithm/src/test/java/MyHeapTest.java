import junit.framework.TestCase;


public class MyHeapTest extends TestCase {
    public void testLeft() {
        int testParentIndex = 1;
        assert (MyHeap.left(testParentIndex) == 2);
        assert (MyHeap.right(testParentIndex) == 3);
        assert (MyHeap.parent(2) == 1);
        assert (MyHeap.parent(3) == 1);
    }

    public void testMaxHeaplify() {
        int[] testArray = {1, 2, 3};
        MyHeap myHeap = new MyHeap(testArray);
        MyHeap.maxHeaplify(myHeap, 1);
        int[] expectedArray = {3, 2, 1};
        MyHeap expectedHeap = new MyHeap(expectedArray);
        assert (myHeap.equals(expectedHeap));
    }

    public void testBuildMaxHeap() {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7};
        MyHeap myHeap = new MyHeap(testArray);
        myHeap.buildMaxHeap();
        assertTrue(myHeap.isMaxHeap());
    }

    public void testHeapSort() {
        int[] testArray = {7, 6, 5, 4, 3, 2, 1};
        MyHeap myHeap = new MyHeap(testArray);
        myHeap.heapSort();
        assertTrue(myHeap.isSorted());
    }
}