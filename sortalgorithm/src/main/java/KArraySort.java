/**
 * Created by T440P on 2017/9/7.
 */

import java.util.PriorityQueue;
import java.util.Queue;

/** MyHeap 是为了理解 heap 写的代码。
 * 实际用的时候，除了 C 语言之后，很多语言都提供了 heap （除了 heap 之外，其他常用的数据结构都提供了）。
 * Java 提供了 优先队列（优先队列都是用 heap 实现的，不过提供一些更好用的接口）
 * python 中 heapq 就是堆
 * 下面的例子，直接使用 heap 来解决实际问题。
 * k 个队列的排列问题， k 个队列中，每个队列事先已经排好序
 */
public class KArraySort {



    /**
     * 把 arrays 代表的多个序列中的元素，按大小顺序写入到 result 中
     * @param arrays
     * @param result
     */
    public static void sortKArray(int[][] arrays, int[] result)
    {
        // 和 k_array_sort.py
        Queue<Integer> integerPriorityQueue = new PriorityQueue<Integer>();
        int k = arrays.length;
        // 保存每个数组的长度
        int[] lengthArray = new int[k];
        // 总共的元素个数
        int elementNum = 0;
        for (int i=0; i < k; i++)
        {
            lengthArray[i] = arrays[i].length;
            elementNum += lengthArray[i];
        }

        for (int i=0; i < k; i++)
        {

        }

    }

    public static void main(String[] args)
    {


    }




}
