import junit.framework.TestCase;

public class QuickSortTest extends TestCase {
    public void testPartition() {
        int a[] = {1, 2, 3, 4, 5, 6};
        int length = a.length;
        assertEquals(QuickSort.partition(a, 0, length - 1), length - 1);
        int b[] = {6, 5, 4, 3, 2, 1};
        length = b.length;
        assertEquals(QuickSort.partition(b, 0, length - 1), 0);
    }

    public void testQuickSort() {
        // 待排序的数组
        int a[] = {7, 9, 2, 11, 42, 10};
        int length = a.length;
        QuickSort.quickSort(a, 0, length - 1);
        // 快排的结果是个排好序的数组
        int expectedResult[] = {2, 7, 9, 10, 11, 42};
        for (int i = 0; i < length; i++) {
            assertEquals(a[i], expectedResult[i]);
        }
    }

    public void testRandomizedPartition() {
        int a[] = {1, 2, 3, 4, 5};
        int length = a.length;
        int firstValue = QuickSort.randomizedPartition(a, 0, length - 1);
        int secondValue = QuickSort.randomizedPartition(a, 0, length -1);

        assert(firstValue != secondValue);
    }

    public void testRandomizedQuickSort() {
        int a[] = {7, 9, 2, 11, 42, 10};
        int length = a.length;
        QuickSort.randomizedQuickSort(a, 0, length - 1);
        // 快排的结果是个排好序的数组
        int expectedResult[] = {2, 7, 9, 10, 11, 42};
        for (int i = 0; i < length; i++) {
            assertEquals(a[i], expectedResult[i]);
        }
    }

}