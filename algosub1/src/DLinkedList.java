
class DLinkedList<T> {
    DNode<T> head, tail;

    public DLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(T data) {
        DNode<T> newNode = new DNode<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(T data) {
        DNode<T> newNode = new DNode<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(T data) {
        DNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                if (current == head) head = current.next;
                if (current == tail) tail = current.prev;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DNode<T> current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}

