class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0) return res;
        
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                
                int front = j+1;
                int back = n-1;
                int target2 = target - nums[i] - nums[j];
                
                while(front < back) {
                    int two_sum = nums[front] + nums[back];
                    
                    if(two_sum < target2) front++;
                    else if(two_sum > target2) back--;
                    else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[front]);
                        temp.add(nums[back]);
                        res.add(temp);
                        
                        while(front < back && nums[front] == temp.get(2)) ++front;
                        while(front < back && nums[back] == temp.get(3)) --back;
                    }
                }
                
                while(j+1 < n && nums[j+1] == nums[j]) ++j;
            }
            while(i+1 < n && nums[i+1] == nums[i]) ++i;
        }
        return res;
    }
}
