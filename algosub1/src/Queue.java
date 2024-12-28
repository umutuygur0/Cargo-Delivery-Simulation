class Queue<T> {
    private DLinkedList<T> list = new DLinkedList<>();

    public void enqueue(T data) {
        list.addLast(data);
    }

    public T dequeue() {
        if (list.head == null) return null;
        T data = list.head.data;
        list.remove(data);
        return data;
    }

    public boolean isEmpty() {
        return list.head == null;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
