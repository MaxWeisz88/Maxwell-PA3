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

    public void insert(GraphNode g){
        if(heapSize >= maxSize){

        }
        heap[++heapSize] = g;
        int i = heapSize;
        map.set(g, i);
        heapDecreaseKey(heap, heapSize, g, g.priority);
        map.set(g, i);//Needs to be the correct index after setting it in right position for heap
    }

    /**
     * Swaps the GraphNode's at indicies a and b in the heap. 
     * @param a first index
     * @param b second index getting swapped
     */
    private void swap(int a, int b){
        GraphNode temp = heap[a];
        map.set(temp, b);
        map.set(heap[b], a);
        heap[a] = heap[b];
        heap[b] = temp;
        //Need to figure out why this is not setting the correct index value in the map after swapped
        
    }

    private int parent(int index){
        return index/2;
    }

    private int left(int index){
        return (2 * index);
    }

    private int right(int index){
        return (2 * index) + 1;
    }

    private boolean isLeaf(int index){
        if(index > (heapSize/2)){
            return true;
        }
        return false;
    }

    public void heapDecreaseKey(GraphNode[] heap, int size, GraphNode key, int newPriority){
        heap[map.getValue(key)].priority = newPriority;
        int currentIndex = 0;
        while(heap[parent(map.getValue(key))] != null && heap[map.getValue(key)].priority < heap[parent(map.getValue(key))].priority){
            currentIndex = map.getValue(key);
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

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

    public GraphNode getMin(){
        return heap[FRONT];
    }

    public void deleteMin(){
        heap[FRONT] = heap[heapSize--];
        heapify(heap[FRONT]);
    }
}
