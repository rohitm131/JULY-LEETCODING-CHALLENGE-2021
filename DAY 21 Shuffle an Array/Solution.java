class Solution {
    
    private int[] nums;
    private Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] randomArray = nums.clone();
        for(int i=nums.length-1; i>0; i--) {
            int j = random.nextInt(i+1);
            int temp = randomArray[i];
            randomArray[i] = randomArray[j];
            randomArray[j] = temp;
        }
        return randomArray;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
