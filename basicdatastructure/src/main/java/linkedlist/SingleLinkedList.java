package linkedlist;

public class SingleLinkedList {
    public SingleLinkedListNode head;

    public SingleLinkedList() {
        this.head = null;
    }

    public static SingleLinkedListNode listSearch(SingleLinkedList L, int k) {
        SingleLinkedListNode x = L.head;
        while (x != null && x.key != k) {
            x = x.next;
        }
        return x;
    }

    public static void listInsert(SingleLinkedList L, SingleLinkedListNode x) {

        x.next = L.head;
        L.head = x;
    }

    /**
     * 已经确保 x 是 L 中的一个节点，下面的方法，把 x 从 L 中删除
     *
     * @param L
     * @param x
     */
    public static void listDelete(SingleLinkedList L, SingleLinkedListNode x) {
        SingleLinkedListNode left = L.head;
        if (left == x) {
            L.head = x.next;
        } else {
            while (left.next != x) {
                left = left.next;
            }
            left.next = x.next;
        }
    }

    public String toString() {
        SingleLinkedListNode x = head;
        String result = "";
        while (x != null) {
            result += x.key;
            x = x.next;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleLinkedList L = new SingleLinkedList();

        for (int i = 0; i < 10; i++) {
            // insert some nodes
            listInsert(L, new SingleLinkedListNode(i, null));
        }

        System.out.println(L);
        // search node
        assert (listSearch(L, 100) == null);

        // get a node
        SingleLinkedListNode a = listSearch(L, 3);

        // delete a node
        listDelete(L, a);

        System.out.println(L);
    }

}
