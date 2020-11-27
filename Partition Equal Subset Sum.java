    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        return sum % 2 == 1 ? false : partition(nums, 0, sum / 2);
    }
    
    private boolean partition(int[] nums, int st, int sum) {
        if(sum == 0)
            return true;
        if(st >= nums.length)
            return false;
        return partition(nums, st + 1, sum - nums[st]) || partition(nums, st + 1, sum);
    }
}