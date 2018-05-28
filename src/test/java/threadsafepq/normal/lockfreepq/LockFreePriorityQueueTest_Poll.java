package threadsafepq.normal.lockfreepq;

import org.junit.Before;
import org.junit.Test;
import threadsafepq.LockFreePriorityQueue;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LockFreePriorityQueueTest_Poll {
    private static final int DEFAULT_INITIAL_CAPACITY = 20;
    private static final int CUSTOM_INITIAL_CAPACITY = 50;
    private LockFreePriorityQueue<Integer> defaultQueue;
 

    @Before
    public void before() {
        defaultQueue = new LockFreePriorityQueue<>();
    }

    @Test
    public void Poll_NoItemsDefaultQueue_ReturnsNull() {
        assertNull(defaultQueue.poll());
    }

    @Test
    public void Poll_SingleItemDefaultQueueNoResize_CorrectlyDequeuesItem() throws InterruptedException {
        defaultQueue.put(1);
        int result = defaultQueue.poll();

        assertEquals(1, result);
    }

    @Test
    public void Poll_InOrderDefaultQueueNoResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = {0, 1, 2, 3, 4, 5};
        int[] outputList = {0, 1, 2, 3, 4, 5};

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }


    @Test
    public void Poll_InOrderDefaultQueueSingleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Poll_InOrderDefaultQueueMultipleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    // break

    @Test
    public void Poll_ReverseOrderDefaultQueueNoResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }


    @Test
    public void Poll_ReverseOrderDefaultQueueSingleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Poll_ReverseOrderDefaultQueueMultipleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    // break

    @Test
    public void Poll_RandomOrderDefaultQueueNoResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        shuffleArray(inputList);
        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Poll_RandomOrderDefaultQueueSingleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Poll_RandomOrderDefaultQueueMultipleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }


    private void testRemoveWithInputList(LockFreePriorityQueue<Integer> queue,
                                         int[] inputList, int[] expectedOutput) {
        for (int i : inputList) {
            queue.put(i);
        }

        for (int i : expectedOutput) {
            int out = queue.poll();
            assertEquals(i, out);
        }
    }

    private void shuffleArray(int[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }
}
