package exercise;

/**
 * 15-6
 * 对于任何一棵树，如果最优解中没有根节点，那么
 */
class Node {
    Node p;
    Node firstChild;
    Node nextBrother;
    int satisfy;
    int sumSatisfy;
    boolean attend;
    boolean set;

    public Node(Node p, Node firstChild, Node nextBrother, int satisfy) {
        this.p = p;
        this.firstChild = firstChild;
        this.nextBrother = nextBrother;
        this.satisfy = satisfy;
        // 没有置位
        this.set = false;
    }
}

// T(root) = max { T(root.child) T(root.child.nextBrother) T(root.nextBrother)...;
// root.satisfy + T.root.child.child
// }
public class TeamBuilding {
    // 最大的满意度
    // 递归的写法容易想，但是时间复杂度高
    public static int teamBuilding(Node root) throws Exception {
        if (root == null) throw new Exception("empty tree");
        if (root.firstChild == null) {
            return root.satisfy;
        }
        int p = Integer.MIN_VALUE;

        Node child = root.firstChild;
        int sum = 0;
        int anotherSum = root.satisfy;
        while (child != null) {
            // root 不参加的情况
            sum += teamBuilding(child);

            Node grandChild = child.firstChild;
            while (grandChild != null) {
                // root 参加的情况
                anotherSum += teamBuilding(grandChild);
                grandChild = grandChild.nextBrother;
            }
            child = child.nextBrother;
        }
        if (anotherSum >= sum) {
            return anotherSum;
        } else {
            return sum;
        }
    }

    /**
     * 为 Node 添加 sum 和 attend 字段，分别表示 以 Node 为 root 的子树参加团建的最大满意度，以及最大满意的方案 root 节点是否需要参加
     * 使用动态规划需要把中介结果保存起来，对于数组非常用意保存，而对于树，最好是在每个节点上添加个字段，保存中间结果。我认为用树中节点的字段保存
     * 中间结果是这个问题带给我的启示。
     * 除此之外，因为表示树使用的是下儿子右兄弟的链表表示的所以使用 bottomUp 的方式不好写。用 备忘录的方式写会比较好写。
     * 一棵树的问题，可以转换成多棵子树的问题
     *
     * @param root
     */
    public static void memoizedTeamBuilding(Node root) {
        if (root.set) {
            return;
        }

        if (root.firstChild == null) {
            root.set = true;
            root.attend = true;
            root.sumSatisfy = root.satisfy;
            return;
        }

        Node child = root.firstChild;
        // root 不参加的情况
        int sum = 0;
        // root 参加的情况
        int anotherSum = root.satisfy;
        while (child != null) {
            memoizedTeamBuilding(child);
            sum += child.sumSatisfy;

            Node grandChild = child.firstChild;

            while (grandChild != null) {
                memoizedTeamBuilding(grandChild);
                anotherSum += grandChild.sumSatisfy;
                grandChild = grandChild.nextBrother;
            }
            child = child.nextBrother;
        }
        if (sum >= anotherSum) {
            root.attend = false;
            root.sumSatisfy = sum;
            root.set = true;
        } else {
            root.attend = true;
            root.sumSatisfy = anotherSum;
            root.set = true;
        }
    }

}
