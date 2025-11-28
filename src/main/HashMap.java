package main;


public class HashMap {
    private static final int DEFAULT_SIZE = 16;
    private static final double DEFAULT_LF = .6;
    private int mapSize;
    private int entries; 
    private double loadFactor = 0.00;
    private double currentLF;
    GraphNode[] keys;
    Entry[] map;

    public HashMap(){
        this(DEFAULT_SIZE, DEFAULT_LF);
    }

    public HashMap(int size){
        this(size, DEFAULT_LF);
    }

    public HashMap(int size, double loadFactor){
        mapSize = size;
        this.loadFactor = loadFactor;
        map = new Entry[mapSize];
        keys = new GraphNode[mapSize];
        currentLF = 0;
        entries = 0;
    }

    public int hashFunction(String key, int size){
        int result = 0;
        int digits = 0;
        char[] charArr = key.toCharArray();
        for(int i = 0; i < 8; i++){
            char ch = charArr[i];
            digits += 7*ch;
        }
        result = digits % size;
        int count = 1;
        while(result < size && map[result] != null && !map[result].getKey().getId().equals(key)){//Checks if collision and not a node being searched for
            result = (result + count * count) % size;
            count++;
        }
        return result;
    }

    private void rehash(){
        int biggerMapSize = mapSize * 2;
        Entry[] temp = new Entry[biggerMapSize];
        GraphNode[] tempKeys = new GraphNode[biggerMapSize];
        int i = 0;
        for(GraphNode node : keys){
            if(node == null){
                break;
            }
            //need to find out way to make this work with biggerMapSize so it probes correctly
            temp[hashFunction(node.getId(), mapSize)] = new Entry(node, getValue(node));
            tempKeys[i] = node;
            i++;
        }
        mapSize = biggerMapSize;
        map = temp;
        keys = tempKeys;
    }

    public int getValue(GraphNode g){
        int value = -1;
        if(hasKey(g)){
            Entry entry = getEntry(g);
            value = entry.getValue();
        }
        return value;
    }

    public void set(GraphNode key, int value){
        if(currentLF >= loadFactor)
            rehash();
        if(hasKey(key)){
            Entry entry = getEntry(key);
            entry.setValue(value);
        }else{
            int i = hashFunction(key.getId(), mapSize);
            map[i] = new Entry(key, value);
            keys[entries] = key;
            entries += 1;
            currentLF = (double)entries/mapSize;
        }
    }

    public Entry getEntry(GraphNode key){
        Entry keysEntry = map[hashFunction(key.getId(), mapSize)];
        return keysEntry;
    }

    public boolean hasKey(GraphNode g){
        boolean containsKey = false;
        if(map[hashFunction(g.getId(), mapSize)] != null){
            containsKey = true;
        }
        return containsKey;
    }

    public int numEntries(){
        return entries;
    }
}
