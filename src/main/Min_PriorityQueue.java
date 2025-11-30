package main;

public class Min_PriorityQueue {
    private static final int DEFAULT_SIZE = 16;
    private int numElements;
    private MinHeap queue;

    public Min_PriorityQueue(){
        queue = new MinHeap(DEFAULT_SIZE);
        numElements = 0;
    }

    public Min_PriorityQueue(int size){
        queue = new MinHeap(size);
        numElements = 0;
    }

    public void insert(GraphNode g){
        queue.insert(g);
        numElements++;
    }

    public GraphNode pullHighestPriorityElement(){
        GraphNode min = queue.getMin();
        queue.deleteMin();
        numElements--;
        return min;
    }

    public void rebalance(GraphNode g){
        queue.heapify(g);
    }

    public boolean isEmpty(){
        if(numElements > 0){
            return true;
        }
        return false;
    }
}
