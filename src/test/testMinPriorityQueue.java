package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.GraphNode;
import main.Min_PriorityQueue;

public class testMinPriorityQueue {
    GraphNode testNode1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
    GraphNode testNode2 = new GraphNode("30bede1a-11ce-4af2-b190-59082acce682", false);
    GraphNode testNode3 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", false);
    GraphNode testNode4 = new GraphNode("46af266f-5d0c-43a1-9f91-4b00ca25f6b3", false);
    GraphNode testNode5 = new GraphNode("4ba797c7-5b24-4577-82b6-ac39152c8423", false);
    GraphNode testNode6 = new GraphNode("a733a462-a578-4374-bdc3-920733a6eafc", false);
    GraphNode testNode7 = new GraphNode("d4b2fd29-6869-4a38-935b-2d537830e30b", false);
    GraphNode testNode8 = new GraphNode("f03af39a-4bd5-4e50-86ec-6ec2f2dcf24e", false);
    GraphNode testNode9 = new GraphNode("6ec0919a-11ba-418a-b81d-2b4bc2443850", false);

    @Test
    public void testInsert(){
        Min_PriorityQueue queue = new Min_PriorityQueue();
        testNode1.priority = 3;
        testNode2.priority = 5;
        testNode3.priority = 1;
        queue.insert(testNode1);
        queue.insert(testNode2);
        assertEquals(queue.pullHighestPriorityElement(), testNode1);
        queue.insert(testNode3);
        assertEquals(queue.pullHighestPriorityElement(), testNode3);
    }
}
