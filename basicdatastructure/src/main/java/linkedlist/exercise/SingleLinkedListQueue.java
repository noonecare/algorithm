package linkedlist.exercise;

import linkedlist.SingleLinkedList;
import linkedlist.SingleLinkedListNode;

/**
 * Created by T440P on 2017/9/28.
 */
public class SingleLinkedListQueue {
    private SingleLinkedList L;
    public SingleLinkedListQueue() {
        this.L = new SingleLinkedList();
    }

    public void enqueue(int k) {
        SingleLinkedList.listInsert(L, new SingleLinkedListNode(k, null));
    }

    public int dequeue() throws RuntimeException{
        if ( L.head == null ) {
            throw new RuntimeException("underflow");
        } else
        {
            SingleLinkedListNode x = L.head;
            if (x.next == null)
            {
                int result = x.key;
                L.head = null;
                return result;
            } else {
                while( x.next.next != null ) {
                    x = x.next;
                }
                int result = x.next.key;
                x.next = null;
                return result;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedListQueue q = new SingleLinkedListQueue();
        for (int i=0; i < 10; i++) {
            q.enqueue(i);
            System.out.println(i);
        }

        for (int i=0; i < 10; i++) {
            System.out.println(q.dequeue());
        }
    }
}
