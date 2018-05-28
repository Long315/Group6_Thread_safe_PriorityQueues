package threadsafepq.normal.lockfreepq;

import org.junit.Before;
import threadsafepq.LockFreePriorityQueue;

public abstract class LockFreePriorityQueueTest {

    static final int DEFAULT_INITIAL_CAPACITY = 20;
    static final int CUSTOM_INITIAL_CAPACITY = 50;
    LockFreePriorityQueue<Integer> defaultQueue;

    @Before
    public void before() {
        defaultQueue = new LockFreePriorityQueue<Integer>();
    }

}
