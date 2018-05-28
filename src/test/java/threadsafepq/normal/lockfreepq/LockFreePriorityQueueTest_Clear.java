package threadsafepq.normal.lockfreepq;

import org.junit.Test;
import threadsafepq.LockFreePriorityQueue;

import static org.junit.Assert.assertEquals;

public class LockFreePriorityQueueTest_Clear extends LockFreePriorityQueueTest {

    @Test
    public void Clear_DefaultQueueEmptyQueueThenClear_ClearsAllElements() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.clear();
        assertEquals(0, queue.toArray().length);
    }

    @Test
    public void Clear_DefaultQueueNonEmptyQueueThenClear_ClearsAllElements() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(1);
        queue.put(3);
        queue.remove();
        queue.clear();
        assertEquals(0, queue.toArray().length);
    }
}
