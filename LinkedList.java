
public class LinkedList<T> implements List<T> {
    // makes node?? that has data of T, next
    class Node<T> {
        T data;
        Node next;
        int size;
        Node head = null;

        public Node(T data) {

            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;// head of the list
    int size;

    public T get(int pos) {
        if (pos < 0 || pos >= size)
            return null;

        Node<T> node = head;
        for (int i = 0; i < pos; i++) {
            node = node.next;

        }
        return node.data;
    }

    public T remove(int pos) {
        // if list is empty just return nothing
        if (pos < 0 || pos >= size)
            return null;
        // if the pos is at the start
        if (pos == 0) {
            Node<T> curr = head;
            head = head.next;
            size--;
            return curr.data;
        }
        // for everywhere else
        Node<T> prev = head;
        for (int i = 0; i < pos - 1; i++)
            prev = prev.next;
        Node<T> curr = prev.next;
        prev.next = curr.next;
        size--;
        return curr.data;

    }

    public void add(T data) {
        if (head == null) {
            Node<T> curr = new Node<T>(data);
            head = curr;
            ++size;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < size - 1; i++)
                prev = prev.next;
            Node<T> curr = new Node<T>(data);
            prev.next = curr;
            ++size;
        }
    }

    public void add(int pos, T data) {

      
        if (pos == 0) {
            Node<T> node = new Node<T>(data);
            node.next = head;
            head = node;
            ++size;
        } else {
            Node<T> node = new Node<T>(data);
            Node prev = head;
            for (int i = 0; i < pos - 1; i++)
                prev = prev.next;
            node.next = prev.next;
            prev.next = node;
            size++;
        }
    }

    public int size() {
        return size;
    }

}