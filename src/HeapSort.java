package Lab9;

public class HeapSort {
    
    /**
     * This method takes in an array on integers and sort them using heap-sort
     * @param input array of integer items
     * @return sorted array
     */
    public static int[] sort(int[]input)
    {
        MaxHeap maxHeap = new MaxHeap(input);
        // Your code goes here
        
        
        // You might change this line and return the sorted array
        return input;
    }
}
