package linkedlist;

/**
 * Created by T440P on 2017/9/28.
 */

public class CircularDoublyLinkedList {
    private DoubleLinkedListNode nil;

    public CircularDoublyLinkedList() {
        this.nil = new DoubleLinkedListNode(0, null, null);
        this.nil.prev = this.nil;
        this.nil.next = this.nil;
    }

    public static DoubleLinkedListNode listSearch(CircularDoublyLinkedList L, int k) {
        DoubleLinkedListNode x = L.nil.next;
        // 通过类型来确定一个节点是不是 NIL
        while ( x != L.nil && x.key != k) {
            x = x.next;
        }
        return x;
    }

    public static boolean isEmpty(CircularDoublyLinkedList L) {
        if (L.nil.next == L.nil.prev) {
            return true;
        }
        return false;
    }

    public static void listInsert(CircularDoublyLinkedList L, DoubleLinkedListNode x) {
        x.next = L.nil.next;
        L.nil.next.prev = x;
        L.nil.next = x;
        x.prev = L.nil;
    }

    public static void listDelete(CircularDoublyLinkedList L, DoubleLinkedListNode x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    @Override
    public String toString() {
        DoubleLinkedListNode x = nil.next;
        String result = "";
        while(x != nil) {
            result += x.key;
            x = x.next;
        }
        return result;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList L = new CircularDoublyLinkedList();

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
