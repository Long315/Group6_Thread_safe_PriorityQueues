package threadsafepq.normal.lockfreepq;

import org.junit.Before;
import org.junit.Test;
import threadsafepq.LockFreePriorityQueue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by Long315 on 28/05/2018.
 */
public class LockFreePriorityQueueTest_Remove {

    private static final int DEFAULT_INITIAL_CAPACITY = 20;
    private static final int CUSTOM_INITIAL_CAPACITY = 50;
    private LockFreePriorityQueue<Integer> defaultQueue;


    @Before
    public void before() {
        defaultQueue = new LockFreePriorityQueue<>();
    }

    @Test(expected = NoSuchElementException.class)
    public void Remove_NoItemsDefaultQueue_ReturnsNull() {
        defaultQueue.remove();
    }

    @Test
    public void Remove_SingleItemDefaultQueueNoResize_CorrectlyDequeuesItem() throws InterruptedException {
        defaultQueue.put(1);
        int result = defaultQueue.remove();

        assertEquals(1, result);
    }

    @Test
    public void Remove_InOrderDefaultQueueNoResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = {0, 1, 2, 3, 4, 5};
        int[] outputList = {0, 1, 2, 3, 4, 5};

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Remove_InOrderDefaultQueueSingleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Remove_InOrderDefaultQueueMultipleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    // break

    @Test
    public void Remove_ReverseOrderDefaultQueueNoResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Remove_ReverseOrderDefaultQueueSingleResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Remove_ReverseOrderDefaultQueueMultipleResize_CorrectlyDequeuesItem() throws InterruptedException {
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
    public void Remove_RandomOrderDefaultQueueNoResize_CorrectlyDequeuesItem() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        shuffleArray(inputList);
        testRemoveWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Remove_RandomOrderDefaultQueueSingleResize_CorrectlyDequeuesItem() throws InterruptedException {
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
    public void Remove_RandomOrderDefaultQueueMultipleResize_CorrectlyDequeuesItem() throws InterruptedException {
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
            int out = queue.remove();
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
