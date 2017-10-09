package linkedlist.exercise;

import linkedlist.SingleLinkedList;
import linkedlist.SingleLinkedListNode;

/**
 * Implement a stack using a singly linked list L. The operations PUSH and POP
 should still take O.1/ time.
 */
public class SingleLinkedListStack {
    private SingleLinkedList L;
    public SingleLinkedListStack() {
        L = new SingleLinkedList();
    }

    public void push(int k) {
        SingleLinkedList.listInsert(this.L, new SingleLinkedListNode(k, null));
    }

    public boolean isEmpty() {
        return L.head == null;
    }

    public int pop() {
        SingleLinkedListNode x = L.head;
        if ( x != null ) {
            SingleLinkedList.listDelete(L, x);
            return x.key;
        } else {
            throw new RuntimeException("underflow");
        }
    }

    public static void main(String[] args) {
        SingleLinkedListStack s = new SingleLinkedListStack();

        for (int i = 0; i < 10; i++ ) {
            s.push(i);
        }
        for (int i = 0; i < 10; i++ ) {
            System.out.println(s.pop());
        }
    }
}
