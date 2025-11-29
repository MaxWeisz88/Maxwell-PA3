package main;

/**
 * 
 */
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

    /**
     * Hash function, given a UUID string this will return an int that is unique to that string. If there is a collision with two different keys 
     * returning the same index, uses quadratic probing to find a free index in the map. Has a map field to put an array of Entry objects so that
     * the rehash function can add to a new larger map without having out of bounds index errors in the old map.
     * @param map the map that is being retrieved from or setting new entries in
     * @param key the UUID string corresponding to an entry
     * @param size the table size of the map being used
     * @return unique index for this key in the map
     */
    public int hashFunction(Entry[] map, String key, int size){
        int result = 0;
        int digits = 0;
        char[] charArr = key.toCharArray();
        for(int i = 0; i < 8; i++){
            char ch = charArr[i];
            digits += 7*ch;
        }
        result = digits % size;
        int count = 1;
        while(result < size && map[result] != null && !map[result].getKey().getId().equals(key)){
            //Checks if there is a collision and it is not a node being searched for
            result = (result + count * count) % size;
            count++;
        }
        return result;
    }

    /**
     * Creates a new map that is double the size of the current map, then adds the entries to the new map using the new size in the hash function.
     * Also updates the array tracking the GraphNode keys, and size fields.
     */
    private void rehash(){
        int biggerMapSize = mapSize * 2;
        Entry[] temp = new Entry[biggerMapSize];
        GraphNode[] tempKeys = new GraphNode[biggerMapSize];
        int i = 0;
        for(GraphNode node : keys){
            if(node == null){
                break;
            }
            temp[hashFunction(temp, node.getId(), biggerMapSize)] = new Entry(node, getValue(node));
            tempKeys[i] = node;
            i++;
        }
        mapSize = biggerMapSize;
        map = temp;
        keys = tempKeys;
    }

    /**
     * Given a GraphNode this retrieves the value (representing index of GraphNode in heap array) associated with it in the map.
     * @param g GraphNode to get value for
     * @return the value in the entry with this GraphNode
     */
    public int getValue(GraphNode g){
        int value = -1;
        if(hasKey(g)){
            Entry entry = getEntry(g);
            value = entry.getValue();
        }
        return value;
    }

    /**
     * Checks if the key being searched for is already in the map, if it is this changes the Entry value field to the value passed in the second 
     * parameter. If it is not already in the map then it gets the hash value for the key and puts the key with the value param in an entry at 
     * that index in the map. 
     * @param key GraphNode key whose corresponding Entry's value is being changed or added
     * @param value value associated with the GraphNode key
     */
    public void set(GraphNode key, int value){
        if(hasKey(key)){
            Entry entry = getEntry(key);
            entry.setValue(value);
        } else{
            int i = hashFunction(this.map, key.getId(), mapSize);
            map[i] = new Entry(key, value);
            keys[entries] = key;
            entries += 1;
            currentLF = (double)entries/mapSize;
        }
        if(currentLF >= loadFactor)
            rehash();
    }

    /**
     * Given a GraphNode as the key this returns the entry that has this GraphNode and an associated value in the map.
     * @param key GraphNode to search for map entry with
     * @return the entry that this GraphNode is the key for
     */
    public Entry getEntry(GraphNode key){
        Entry keysEntry = map[hashFunction(this.map, key.getId(), mapSize)];
        return keysEntry;
    }

    /**
     * Given a GraphNode this returns true if the map already contains this key in an entry and false if there is no entry in the map with this
     * GraphNode as the key.
     * @param g GraphNode to check if it is in the map
     * @return true if GraphNode is in the map, false if not
     */
    public boolean hasKey(GraphNode g){
        boolean containsKey = false;
        if(map[hashFunction(this.map, g.getId(), mapSize)] != null){
            containsKey = true;
        }
        return containsKey;
    }

    /**
     * Returns the number of Entry objects currently being stored in the map.
     * @return number of Entry objects in map
     */
    public int numEntries(){
        return entries;
    }
}
