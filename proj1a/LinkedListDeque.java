/** This project is to create a Deque class */

public class LinkedListDeque <T> {
    public class Node {
        public T item;
        public Node next;
        public Node prev;


        public Node(Node p, T i, Node n) {
            item = i;
            next = n;
            prev = p;

        }
    }

    public Node sentinel;
    private int size;


    /** define LinkedListDeque with only one element */
    public LinkedListDeque(T x) {
        sentinel = new Node(null, null,null);
        Node n = new Node(null, x, null);
        sentinel.next = n;
        n.next = sentinel;
        sentinel.prev = n;
        n.prev = sentinel;
        sentinel.next.next = sentinel;
        size = 1;
    }

    /** create an empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel = new Node(null, null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }

    /** add an item to the first of the list */
    public void addFirst(T x) {
        Node n = new Node (null, x, null);
        n.next = sentinel.next;
        sentinel.next.prev = n;
        sentinel.next = n;
        n.prev = sentinel;
        size += 1;

    }



    /** add an item x to the last of the list */
    public void addLast(T x) {
        Node n = new Node(null, x, null);
        n.prev = sentinel.prev;
        sentinel.prev.next = n;
        n.next = sentinel;
        sentinel.prev = n;
        size += 1;

    }

    /** remove and return the first item in the list */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }else {
            T first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return first;
        }
    }

    /** remove the last item in the list, if exists */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T last = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return last;
        }
    }

    /** gets the item at given index by iteration */
    public T get(int index) {
        Node p = sentinel;
        if (index > size - 1) {
            return null;
        } else {
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            T result = p.item;
            return result;
        }

    }

    /** helper method */
    private T getHelper(int index,Node s){
        if (s.next == sentinel ) {
            return null;
        } else {
            if (index == 0) {
                return s.next.item;
            } else {
                return getHelper(index - 1,s.next);
            }

        }
    }

    /** gets the item at given index by recursion */
    public T getRecursive(int index) {
          return getHelper(index, sentinel);
    }






    /** if list is empty, return true, else return false */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** returns the number of items in the list */
    public int size(){
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            System.out.println("The deque is empty");
        } else {
            Node p = sentinel;
            for (int i = 0; i < size; i++) {
                System.out.print(p.next.item + "\t");
                p = p.next;
            }
        }

    }

}


