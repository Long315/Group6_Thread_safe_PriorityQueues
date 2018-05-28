package threadsafepq.normal.lockfreepq;

import org.junit.Test;
import threadsafepq.LockFreePriorityQueue;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by Long315 on 28/05/2018.
 */

public class LockFreePriorityQueueTest_Put extends LockFreePriorityQueueTest {

    @Test
    public void Put_SingleNoResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        defaultQueue.put(1);
        int result = defaultQueue.remove();

        assertEquals(1, result);
    }

    @Test
    public void Put_InOrderNoResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {0, 1, 2, 3, 4, 5};
        int[] outputList = {0, 1, 2, 3, 4, 5};

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Put_InOrderSingleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Put_InOrderMultipleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    // Reverse Order tests
    @Test
    public void Put_ReverseOrderNoResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Put_ReverseOrderSingleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Put_ReverseOrderMultipleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Put_RandomOrderNoResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        shuffleArray(inputList);
        testPutWithInputList(defaultQueue, inputList, outputList);
    }


    @Test
    public void Put_RandomOrderSingleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Put_RandomOrderMultipleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    private void testPutWithInputList(LockFreePriorityQueue<Integer> queue,
                                      int[] inputList, int[] expectedOutput) {
        for (int i : inputList) {
            queue.put(i);
        }

        Object[] output = queue.toArray();
        Arrays.sort(output);

        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], (int) output[i]);
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