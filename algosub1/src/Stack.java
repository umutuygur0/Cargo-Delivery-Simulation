class Stack<T> {
    private DLinkedList<T> list = new DLinkedList<>();

    public void push(T data) {
        list.addFirst(data);
    }

    public T pop() {
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
