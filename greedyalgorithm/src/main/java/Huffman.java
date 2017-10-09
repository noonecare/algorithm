import java.util.PriorityQueue;

class CharNode implements Comparable<CharNode> {
    public double frequency;
    public char c;
    public CharNode(double frequency, char c) {
        this.frequency = frequency;
        this.c = c;
    }

    public int compareTo(CharNode o) {
        if ( this.frequency > o.frequency ) {
            return 0;
        } else
        {
            return 1;
        }
    }
}

public class Huffman {
    // 这里用的 BinarySearchTree 是我在 binarysearchtree 章节实现的 binarysearchtree.
    public static BinarySearchTree huffman(CharNode[] C) {
        int n = C.length;
        PriorityQueue<CharNode> Q = new PriorityQueue<CharNode>();
        for (CharNode c: C) {
            Q.add(c);
        }

    }
}

/**
 * 前缀码： 没有任何码字是其他码字的前缀
 * 最优前缀码：对于文本，编码长度最小的前缀码
 */
