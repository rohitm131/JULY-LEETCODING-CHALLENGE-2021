class Solution {
    
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
            if(map.get(i) >= n/2) return 1;
        }
        
        List<Integer> freq = new ArrayList<>(map.values());
        freq.sort((a,b) -> b-a);
        
        int count = 0;
        int sum = 0;
        
        for(int i : freq) {
            sum += i;
            count++;
            if(sum >= n/2) return count;
        }
        
        return count;
        
    }
}
