package main;

public class MinHeap {
    public HashMap map;
    private GraphNode[] heap;
    private int heapSize;
    private int maxSize;
    private static final int FRONT = 1;

    public MinHeap(){
        this(16);
    }

    public MinHeap(int size){
        heapSize = 0;
        maxSize = size;
        map = new HashMap(size);
        heap = new GraphNode[maxSize + 1];
    }

    /**
     * Inserts the GraphNode passed as the parameter into the heap. Checks first if the heap needs to be expanded and if so doubles the max size
     * of the heap then adds the GraphNode to the heap.
     * @param g GraphNode g being added to the heap
     */
    public void insert(GraphNode g){
        if(heapSize >= maxSize){
            expandHeap();
        }
        heap[++heapSize] = g;
        int i = heapSize;
        map.set(g, i);
        heapDecreaseKey(heap, heapSize, g, g.priority);
    }

    /**
     * Helper method to expand the heap size to double its current max size and copies over all elements in the current heap. 
     */
    private void expandHeap(){
        int larger = maxSize * 2;
        GraphNode[] temp = new GraphNode[larger + 1];
        for(int i = FRONT; i < maxSize + 1; i++){
            temp[i] = heap[i];
        }
        maxSize = larger;
        heap = temp;
    }

    /**
     * Swaps the GraphNode's at indicies a and b in the heap and sets the map entry with those GraphNodes with their new index values. 
     * @param a first index
     * @param b second index getting swapped
     */
    private void swap(int a, int b){
        GraphNode temp = heap[a];
        map.set(temp, b);
        map.set(heap[b], a);
        heap[a] = heap[b];
        heap[b] = temp;        
    }

    /**
     * Returns the parent's index for the index passed.
     * @param index index to get the parent for
     * @return this index's parent index
     */
    private int parent(int index){
        return index/2;
    }

    /**
     * Returns the left index for the index passed.
     * @param index index to get the left index for
     * @return this index's left index
     */
    private int left(int index){
        return (2 * index);
    }

    /**
     * Returns the right index for the index passed.
     * @param index index to get the right index for
     * @return this index's right index
     */
    private int right(int index){
        return (2 * index) + 1;
    }

    /**
     * Helper method to check if this index represents a leaf.
     * @param index index to check if it is a leaf
     * @return true if this is a leaf, false if not
     */
    private boolean isLeaf(int index){
        if(index > (heapSize/2)){
            return true;
        }
        return false;
    }

    /**
     * Decreases the priority field of the GraphNode passed to the new priority in the heap. Changes the priority then checks if with the new 
     * priority value it should be swapped with its parent to maintain min-heap property. 
     * @param heap the heap this GraphNode is in
     * @param size the size of the heap
     * @param key the GraphNode whose priority is being decreased
     * @param newPriority the new priority value to change the GraphNode's priority to
     */
    public void heapDecreaseKey(GraphNode[] heap, int size, GraphNode key, int newPriority){
        heap[map.getValue(key)].priority = newPriority;
        int currentIndex = 0;
        while(heap[parent(map.getValue(key))] != null && heap[map.getValue(key)].priority < heap[parent(map.getValue(key))].priority){
            currentIndex = map.getValue(key);
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    /**
     * Maintains the min-heap property by swapping the GraphNode with its right or left indicies in the heap if they exist and either of the 
     * GraphNodes at those indicies have a smaller priority value.
     * @param g GraphNode to heapify at
     */
    public void heapify(GraphNode g){
        int index = map.getValue(g);
        if(!isLeaf(index)){
            int swapIdx = index;
            if(right(index)<=heapSize && heap[right(index)] != null){
                if(heap[left(index)].priority < heap[right(index)].priority){
                    swapIdx = left(index);
                }else{
                    swapIdx = right(index);
                }
            }else {
                swapIdx = left(index);
            }
            if((heap[left(index)] != null && heap[index].priority > heap[left(index)].priority) 
            || (heap[right(index)] != null && heap[index].priority > heap[right(index)].priority)){
                swap(index, swapIdx);
                heapify(heap[swapIdx]);
            }
        }
    }

    /**
     * Returns the GraphNode at the top of the heap(the GraphNode with the lowest priority value).
     */
    public GraphNode getMin(){
        return heap[FRONT];
    }

    /**
     * Deletes the GraphNode at the top of the heap, sets the GraphNode at the last index in the heap to the front then calls heapify at the 
     * top to maintain min-heap property. 
     */
    public void deleteMin(){
        GraphNode temp = heap[FRONT];
        heap[FRONT] = heap[heapSize--];
        map.getEntry(getMin()).setValue(FRONT);
        map.getEntry(temp).setValue(-1);
        heapify(heap[FRONT]);
    }

    /**
     * Method to get the maxSize value that this heap's array has.
     * @return heaps current maxSize value
     */
    public int getMaxSize(){
        return maxSize;
    }

    public int getHeapSize(){
        return heapSize;
    }
}
