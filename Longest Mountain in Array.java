class Solution {
 public int longestMountain(int[] A) {
        int max = 0, inc = 0, dec = 0;
        
        for(int i=1; i<A.length; i++){
            if(A[i] > A[i-1]){       // Current number greater than the previous
                if(dec > 0) inc = 0; // Reset inc if we had a decreasing sequence until the previous
				inc++;               // Increment inc
                dec = 0;             // Reset dec
            }
            else if(A[i] < A[i-1]){  // Current number smaller than the previous
                if(inc > 0){         // No need to do anything if we did not have an increasing sequence
                    dec++;           // Increment dec
                    max = Math.max(max, inc + dec + 1);  // Determine max for the current mountain
                }
            }
            else inc = dec = 0;      // Current number same as the previous, reset inc and dec
        }
        
        return max;
    }
}