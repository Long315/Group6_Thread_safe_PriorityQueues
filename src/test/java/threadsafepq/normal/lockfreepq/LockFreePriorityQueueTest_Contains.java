package threadsafepq.normal.lockfreepq;

import org.junit.Test;
import threadsafepq.LockFreePriorityQueue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Long315 on 28/05/2018.
 */

public class LockFreePriorityQueueTest_Contains extends LockFreePriorityQueueTest {

    @Test
    public void Contains_DefaultQueueEmpty_ReturnsFalse() {
        LockFreePriorityQueue<Integer> queue = defaultQueue;
        assertEquals(false, queue.contains(0));
    }

    @Test
    public void Contains_DefaultQueueSingleItemWhichExists_ReturnsTrue() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(0);
        assertEquals(true, queue.contains(0));
    }

    @Test
    public void Contains_DefaultQueueSingleItemWhichDoesNotExist_ReturnsFalse() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(0);
        assertEquals(false, queue.contains(1));
    }

    @Test
    public void Contains_DefaultQueueMultipleItemsWhichExist_ReturnsTrue() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(0);
        queue.put(1);
        queue.put(3);
        assertEquals(true, queue.contains(0));
        assertEquals(true, queue.contains(1));
        assertEquals(true, queue.contains(3));
    }

    @Test
    public void Contains_DefaultQueueMultipleItemsWhichDoNotExist_ReturnsFalse() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        queue.put(0);
        queue.put(1);
        queue.put(3);
        assertEquals(false, queue.contains(4));
        assertEquals(false, queue.contains(5));
    }


    @Test
    public void ContainsAll_DefaultQueueEmpty_ReturnsFalse() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(false, queue.containsAll(list));
    }

    @Test
    public void ContainsAll_DefaultQueueWithAllItemsExisting_ReturnsTrue() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
            queue.put(i);
        }

        assertEquals(true, queue.containsAll(list));
    }

    @Test
    public void ContainsAll_DefaultQueueWithSomeItemsMissing_ReturnsFalse() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
            queue.put(i);
        }

        queue.remove();
        queue.remove();
        queue.remove();

        assertEquals(false, queue.containsAll(list));
    }

    @Test
    public void ContainsAll_DefaultQueueWithOneItemMissing_ReturnsFalse() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
            queue.put(i);
        }

        queue.remove();

        assertEquals(false, queue.containsAll(list));
    }

    @Test
    public void Contains_DefaultQueueWithNullElements_ThrowsNullPointerException() {
    	LockFreePriorityQueue<Integer> queue = defaultQueue;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
            queue.put(i);
        }

        list.set(5, null);

        assertEquals(false,queue.containsAll(list));
    }
}
