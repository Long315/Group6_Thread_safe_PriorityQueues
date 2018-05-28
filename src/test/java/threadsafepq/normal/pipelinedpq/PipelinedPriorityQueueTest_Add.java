package threadsafepq.normal.pipelinedpq;

import org.junit.Test;
import threadsafepq.PipelinedPriorityQueue;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class PipelinedPriorityQueueTest_Add extends PipelinedPriorityQueueTest {

    @Test
    public void Add_SingleNoResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        defaultQueue.add(1);
        int result = defaultQueue.remove();

        assertEquals(1, result);
    }

    @Test
    public void Add_SingleNoResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        capacityQueue.add(1);
        int result = capacityQueue.remove();

        assertEquals(1, result);
    }

    @Test
    public void Add_SingleNoResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        capacityComparatorQueue.add(1);
        int result = capacityComparatorQueue.remove();

        assertEquals(1, result);
    }

    @Test
    public void Add_InOrderNoResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {0, 1, 2, 3, 4, 5};
        int[] outputList = {0, 1, 2, 3, 4, 5};

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Add_InOrderNoResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {0, 1, 2, 3, 4, 5};
        int[] outputList = {0, 1, 2, 3, 4, 5};

        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_InOrderNoResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    @Test
    public void Add_InOrderSingleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Add_InOrderSingleResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY + 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_InOrderSingleResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY + 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    @Test
    public void Add_InOrderMultipleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Add_InOrderMultipleResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_InOrderMultipleResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = i;
        }
        int[] outputList = Arrays.copyOf(inputList, inputList.length);

        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    // Reverse Order tests
    @Test
    public void Add_ReverseOrderNoResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Add_ReverseOrderNoResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_ReverseOrderNoResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    @Test
    public void Add_ReverseOrderSingleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[DEFAULT_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Add_ReverseOrderSingleResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_ReverseOrderSingleResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    @Test
    public void Add_ReverseOrderMultipleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Add_ReverseOrderMultipleResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_ReverseOrderMultipleResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    @Test
    public void Add_RandomOrderNoResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        shuffleArray(inputList);
        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Add_RandomOrderNoResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {5, 4, 3, 2, 1};
        int[] outputList = {1, 2, 3, 4, 5};

        shuffleArray(inputList);
        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_RandomOrderNoResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = {1, 2, 3, 4, 5};
        int[] outputList = {1, 2, 3, 4, 5};

        shuffleArray(inputList);
        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    @Test
    public void Add_RandomOrderSingleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
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
    public void Add_RandomOrderSingleResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_RandomOrderSingleResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY + 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    @Test
    public void Add_RandomOrderMultipleResizeDefaultQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testPutWithInputList(defaultQueue, inputList, outputList);
    }

    @Test
    public void Add_RandomOrderMultipleResizeCapacityQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testPutWithInputList(capacityQueue, inputList, outputList);
    }

    @Test
    public void Add_RandomOrderMultipleResizeCapacityComparatorQueue_CorrectEnqueue() throws InterruptedException {
        int[] inputList = new int[CUSTOM_INITIAL_CAPACITY * 5];
        int[] outputList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            inputList[i] = inputList.length - i - 1;
            outputList[i] = i;
        }

        shuffleArray(inputList);
        testPutWithInputList(capacityComparatorQueue, inputList, outputList);
    }

    private void testPutWithInputList(PipelinedPriorityQueue<Integer> queue,
                                      int[] inputList, int[] expectedOutput) {
        for (int i : inputList) {
            queue.add(i);
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
