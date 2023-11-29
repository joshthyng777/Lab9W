import java.util.LinkedList;
import java.util.Queue;

public class RadixSortQueue {
	// Used for finding the queue
	static final int RADIX_BASE = 10;
	static final int[] POWERS_OF_TEN = { 1, 10, 100 };
	Queue[] queues;

	public RadixSortQueue() {
		generateQueues();
	}

	/**
	 * Creates an array of queues -- LinkedList is used for queue
	 */
	private void generateQueues() {
		queues = new Queue[RADIX_BASE];
		for (int i = 0; i < RADIX_BASE; i++)
			queues[i] = new LinkedList<Integer>();
	}

	/**
	 * @param input array of int to be sorted (only integers with 3 digits ranging
	 *              from 100 to 999
	 * @return sorted array
	 */
	public int[] sort(int[] input) {
		for (int pass = 1; pass <= 3; pass++) {

			// this value is used to get the corresponding digit in each pass
			int divisor = POWERS_OF_TEN[pass - 1];

			// this method will add the values to the corresponding queue
			updateQueues(input, divisor);

			// Your code goes here
			// Put items back to the array from the queues
			int index = 0;
			for (Queue<Integer> queue : queues) {
				while (!queue.isEmpty()) {
					input[index++] = queue.poll();
				}
			}

		}

		// you may modify this line if needed
		return input;
	}

	private void updateQueues(int[] input, int divisor) {
		// empty the queues
		generateQueues();

		for (int num : input) {
			int queueIndex = (num / divisor) % RADIX_BASE;
			queues[queueIndex].add(num);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 100, 200, 333, 431, 198 };
		RadixSortQueue r = new RadixSortQueue();
		r.sort(arr);
	}
}
