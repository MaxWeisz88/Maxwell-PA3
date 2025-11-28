package main;

public class Entry {
    private GraphNode key;
    private int value;

    public Entry(GraphNode key, int value){
        this.key = key;
        this.value = value;
    }

    public GraphNode getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public boolean equals(Entry entry){
        if(entry.value == this.value && entry.key.equals(this.key)){
            return true;
        }
        return false;
    }
}
