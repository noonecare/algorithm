/**
 * Created by T440P on 2017/10/4.
 */
public class RedBlackTree {

    private ColoredNode root;

    public RedBlackTree() {}

    // 通过 rotate 把左分支中的节点，转给有分支。配合 rightRotate 就可以平衡左右分支的节点数目
    private static void leftRotate(RedBlackTree T, ColoredNode x) {
        ColoredNode y = x.right;
        x.right = y.left;
        if ( y.left != null ) {
            y.left.p = x;
        }
        y.p = x.p;

        if ( x.p == null ) {
            T.root = y;
        } else {
            if ( x == x.p.left ) {
                x.p.left = y;
            } else {
                x.p.right = y;
            }
        }
        y.left = x;
        x.p = y;
    }

    private static void rightRotate(RedBlackTree T, ColoredNode x) {

        ColoredNode y = x.left;
        x.left = y.right;
        if ( y.right != null ) {
            y.right.p = x;
        }
        y.p = x.p;

        if ( x.p == null ) {
            T.root = y;
        } else {
            if ( x == x.p.right ) {
                x.p.right = y;
            } else {
                x.p.left = y;
            }
        }
        y.left = x;
        x.p = y;
    }

    public static void RBInsert(RedBlackTree T, ColoredNode z) {
        ColoredNode y = null;
        ColoredNode x = T.root;

        while ( x != null )
        {
            y = x;
            if ( y.key < x.key )
            {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.p = y;

        if ( y == null ) {
            T.root = z;
        } else {
            if ( z.key < y.key ) {
                y.left = z;
            } else {
                y.right = z;
            }
        }
        z.left = null;
        z.right = null;
        z.color = Color.RED;
        RBInsertFixup(T, z);
    }

    private static void RBInsertFixup(RedBlackTree T, ColoredNode z) {
        while ( z.p.color == Color.RED ) {
            if ( z.p == z.p.p.left ) {
                ColoredNode y = z.p.p.right;
                if ( y.color == Color.RED ) {
                    z.p.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.p.p.color = Color.RED;
                    z = z.p.p;
                } else {
                    if ( z == z.p.right ) {
                        z = z.p;
                        leftRotate(T, z);
                    }
                    z.p.color = Color.BLACK;
                    z.p.p.color = Color.RED;
                    rightRotate(T, z.p.p);
                }
            } else {
                ColoredNode y = z.p.p.left;
                if ( y.color == Color.RED ) {
                    z.p.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.p.p.color = Color.RED;
                    z = z.p.p;
                } else {
                    if ( z == z.p.left ) {
                        z = z.p;
                        rightRotate(T, z);
                    }
                    z.p.color = Color.BLACK;
                    z.p.p.color = Color.RED;
                    leftRotate(T, z.p.p);
                }
            }
        }
    }

    private static void RBTransplant(RedBlackTree T, ColoredNode u, ColoredNode v) {
        if ( u.p == null ) {
            T.root = v;
        } else {
            if ( u == u.p.left ) {
                u.p.left = v;
            } else {
                u.p.right = v;
            }
        }
        v.p = u.p;
    }

    private ColoredNode treeMinimum(ColoredNode x) {
        while ( x.left != null ) {
            x = x.left;
        }
        return x;
    }

    private ColoredNode treeMaximum(ColoredNode x) {
        while ( x.right != null ) {
            x = x.right;
        }
        return x;
    }

    public static void RBDelete(RedBlackTree T, ColoredNode z) {
        ColoredNode y = z;
        Color yOriginalColor = y.color;

        if ( z.left == null ) {
            ColoredNode x = z.right;
            RBTransplant(T, z, z.right);
        } else {
            if ( z.right == null ) {
                ColoredNode x = z.left;
                RBTransplant(T, z, z.left);
            } else {
                y = T.treeMinimum(z.right);
                yOriginalColor = y.color;
                ColoredNode x = y.right;
                if ( y.p == z) {
                    x.p = z;
                }
            }
        }
    }
}
