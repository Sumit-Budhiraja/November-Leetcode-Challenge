class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int s=0,e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target || nums[s]==target || nums[e]==target) return true;
			//Left side is sorted
            else if(nums[s]<nums[mid]){
				//If target is within range of  (nums[start],nums[mid])
                if(nums[s]<target && target<nums[mid]) e=mid-1;            
				//Else search in right part
                else s=mid+1;
            }
			//Right side is sorted
           else  if(nums[mid]<nums[e]) {
		       //If target is within range of  (nums[mid],nums[end])
                if( nums[mid]<target && target<nums[e]) s=mid+1;              
				//Else search in left part
                else e=mid-1;
            }
			//We definitely cant say which side is sorted, so reduce search space by 1 and repeat
           else e--;
        }
        return false;
    }
}