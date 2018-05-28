package threadsafepq.normal.lockfreepq;

import org.junit.Test;

import threadsafepq.LockFreePriorityQueue;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class LockFreePriorityQueue_Element extends LockFreePriorityQueueTest {

    @Test(expected = NoSuchElementException.class)
    public void Peek_DefaultQueueEmptyQueue_ThrowsException() {
        LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.element();
    }

    @Test
    public void Peek_DefaultQueueSingleItemQueue_ReturnsItem() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(1);
        assertEquals(1, (int) queue.element());
    }

    @Test
    public void Peek_DefaultQueueMultipleItemsQueue_ReturnsCorrectTop() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(2);
        queue.put(3);
        assertEquals(2, (int) queue.element());
    }
}
