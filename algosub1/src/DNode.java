class DNode<T> {
    T data;
    DNode<T> next, prev;

    public DNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}