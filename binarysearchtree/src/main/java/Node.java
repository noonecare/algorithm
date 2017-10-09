/**
 * Created by T440P on 2017/10/4.
 */

public class Node {
    // 坐支节点
    public Node left;
    // 右支节点
    public Node right;
    // 父亲节点
    public Node p;
    // 关键字
    public int key;

    public Node(Node left, Node right, Node p, int key) {
        this.left = left;
        this.right = right;
        this.p = p;
        this.key = key;
    }
}
