public class BinarySearchTree {
    public Node root;

    /**
     * 初始化为一个空树
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * 插入搜索二叉树
     */
    public static void treeInsert(BinarySearchTree T, Node z) {
        Node y = null;
        Node x = T.root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == null) {
            T.root = z;
        } else {
            if (z.key < y.key) {
                y.left = z;
            } else {
                y.right = z;
            }
        }
    }


    private static void transplant(BinarySearchTree T, Node u, Node v) {
        if (u.p == null) {
            T.root = v;
        } else {
            if (u == u.p.left) {
                u.p.left = v;
            } else {
                u.p.right = v;
            }
        }

        if (v != null) {
            v.p = u.p;
        }
    }

    public static void treeDeletion(BinarySearchTree T, Node z) {
        if (z.left == null) {
            transplant(T, z, z.right);
        } else {
            if (z.right == null) {
                transplant(T, z, z.left);
            } else {
                Node y = T.treeMinimum(z.right);
                if (y.p != z) {
                    transplant(T, y, y.right);
                    y.right = z.right;
                    y.right.p = y;
                }

                transplant(T, z, y);
                y.left = z.left;
                y.left.p = y;
            }
        }
    }

    public Node treeMinimum(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public Node treeMaximum(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public Node treeSuccessor(Node x) {
        if (x.right != null) {
            return treeMinimum(x.right);
        }
        Node y = x.p;

        // 到第一个有右支节点的节点
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }

    public Node treePredecessor(Node x) {
        // 几乎和上面的一样
        if (x.left != null) {
            return treeMaximum(x.left);
        }
        Node y = x.p;
        while (y != null && x == y.left) {
            x = y;
            y = y.p;
        }
        return y;
    }

    // 中序遍历
    public void inorderTreeWalk(Node x) {
        if (x != null) {
            inorderTreeWalk(x.left);
            System.out.println(x.key);
            inorderTreeWalk(x.right);
        }
    }

    // 前序排列
    public void preorderTreeWalk(Node x) {
        if (x != null) {
            System.out.println(x.key);
            preorderTreeWalk(x.left);
            preorderTreeWalk(x.right);
        }
    }

    // 中序排列
    public void postorderTreeWalk(Node x) {
        if (x != null) {
            postorderTreeWalk(x.left);
            postorderTreeWalk(x.right);
            System.out.println(x.key);
        }
    }

    public Node treeSearch(Node x, int k) {
        if (x != null || k == x.key) {
            return x;
        }
        if (k < x.key) {
            return treeSearch(x.left, k);
        } else {
            return treeSearch(x.right, k);
        }
    }

    public Node iterativeTreeSearch(Node x, int k) {
        while (x != null && k != x.key) {
            if (k < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }
}
