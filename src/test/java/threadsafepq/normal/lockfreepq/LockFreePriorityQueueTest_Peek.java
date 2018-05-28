package threadsafepq.normal.lockfreepq;

import org.junit.Test;
import threadsafepq.LockFreePriorityQueue;

import static org.junit.Assert.assertEquals;

public class LockFreePriorityQueueTest_Peek extends LockFreePriorityQueueTest {

    @Test
    public void Peek_DefaultQueueEmptyQueue_ReturnsNull() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        assertEquals(null, queue.peek());
    }

    @Test
    public void Peek_DefaultQueueSingleItemQueue_ReturnsItem() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(1);
        assertEquals(1, (int) queue.peek());
    }

    @Test
    public void Peek_DefaultQueueMultipleItemsQueue_ReturnsCorrectTop() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(2);
        queue.put(3);
        assertEquals(2, (int) queue.peek());
    }
}
