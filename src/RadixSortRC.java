//RadixSortRc by Josh Thyng


public class RadixSortRC {
   // The array keeping the digit counts
   int[] digitCounts;
  
   // The array keeping the running counts
   int[] runningCounts;
  
   // Used for finding digit and running counts
   static final int RADIX_BASE = 10;
   static final int[] POWERS_OF_TEN = {1, 10, 100};
  
  
  
   public RadixSortRC()
   {
       digitCounts = new int[RADIX_BASE];
       runningCounts = new int[RADIX_BASE];
   }
  
   /**
    * @param input array of int to be sorted (only integers with 3 digits ranging from 100 to 999
    * @return sorted array
    */
   public int[] sort(int[] input) {
       int[] copyArray = new int[input.length];
      
       for (int pass = 1; pass <= 3; pass++) {
           int divisor = POWERS_OF_TEN[pass - 1];
          
           updateDigitCounts(input, divisor);
           updateRunningCounts();
  
           for (int i = input.length - 1; i >= 0; i--) {
               int digit = (input[i] / divisor) % RADIX_BASE;
               copyArray[runningCounts[digit] - 1] = input[i];
               runningCounts[digit]--;


           }
  
           System.arraycopy(copyArray, 0, input, 0, input.length);
          
       }
      
       return input;
   }
  


   private void updateRunningCounts() {
       // updats the running counts
       runningCounts = new int[RADIX_BASE];
       runningCounts[0] = 0;
       for(int i=0; i<runningCounts.length-1; i++)
           runningCounts[i+1] = digitCounts[i]+runningCounts[i];
   }


   private void updateDigitCounts(int[] input, int divisor) {
       // updates the digit counts
       digitCounts = new int[RADIX_BASE];
       for(int num: input)
           digitCounts[(num/divisor)%RADIX_BASE]++;
      
   }
  
   public static void main(String[] args) {
       // TODO Auto-generated method stub
       int[]arr = {100,200,333,431,198};
       RadixSortRC r = new RadixSortRC();
       r.sort(arr);
   }


}

