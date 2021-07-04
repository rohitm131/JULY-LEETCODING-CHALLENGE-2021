class Solution {
    
    private HashMap<String, Long> dp = new HashMap<>();
    private int MOD = 1000000007;
    
    public long count(int n, char c) {
        if(dp.containsKey(n+" "+c)) return dp.get(n+" "+c);
        
        //Base Case
        if(n==1) return 1;
        
        long ans = 0;
        if(c == 'a') {
            ans = (count(n-1, 'e'))%MOD;
        } else if(c == 'e') {
            ans = (count(n-1, 'a') + count(n-1, 'i'))%MOD;
        } else if(c == 'i') {
            ans = (count(n-1, 'a') + count(n-1, 'e') + count(n-1, 'o') + count(n-1, 'u'))%MOD;
        } else if(c == 'o') {
            ans = (count(n-1, 'i') + count(n-1, 'u'))%MOD;
        } else if(c == 'u') {
            ans = (count(n-1, 'a'))%MOD;
        }
        
        dp.put(n+" "+c, ans);
        return ans;
        
    }
    
    public int countVowelPermutation(int n) {
        
        long a = count(n, 'a');
        long e = count(n, 'e');
        long i = count(n, 'i');
        long o = count(n, 'o');
        long u = count(n, 'u');
        
        return (int)((a+e+i+o+u)%MOD);
        
    }
    
}
