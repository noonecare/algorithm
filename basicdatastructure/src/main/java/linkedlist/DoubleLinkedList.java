package linkedlist;

/**
 * Created by T440P on 2017/9/27.
 */
class DoubleLinkedListNode {
    public int key;
    public DoubleLinkedListNode next;
    public DoubleLinkedListNode prev;

    public DoubleLinkedListNode(int key, DoubleLinkedListNode next, DoubleLinkedListNode prev) {
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
}

public class DoubleLinkedList {
    public DoubleLinkedListNode head;

    public DoubleLinkedList(DoubleLinkedListNode head) {
        this.head = head;
    }

    public static DoubleLinkedListNode listSearch(DoubleLinkedList L, int k) {
        DoubleLinkedListNode x = L.head;
        while (x != null && x.key != k) {
            x = x.next;
        }
        return x;
    }

    public static void listInsert(DoubleLinkedList L, DoubleLinkedListNode x) {
        x.next = L.head;
        if (L.head != null) {
            L.head.prev = x;
        }
        L.head = x;
        x.prev = null;
    }

    public static void listDelete(DoubleLinkedList L, DoubleLinkedListNode x) {
        if (x.prev != null) {
            x.prev.next = x.next;
        } else {
            L.head = x.next;
        }

        if (x.next != null) {
            x.next.prev = x.prev;
        }
    }

    public String toString() {
        DoubleLinkedListNode a = head;
        String result = "";
        while (a != null) {
            result += a.key;
            a = a.next;
        }
        return result;
    }

    public static void main(String[] args) {
        DoubleLinkedList L = new DoubleLinkedList(null);

        for (int i = 0; i < 10; i++) {
            // insert some nodes
            listInsert(L, new DoubleLinkedListNode(i, null, null));
        }

        System.out.println(L);
        // search node
        assert (listSearch(L, 100) == null);

        // get a node
        DoubleLinkedListNode a = listSearch(L, 3);

        // delete a node
        listDelete(L, a);

        System.out.println(L);
    }
}
