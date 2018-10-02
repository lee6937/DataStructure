public interface PriorityQueue {
    boolean isEmpty();
    boolean isFull();

    void add(int element);
    int max();
    int removeMax();
    int size();
}
