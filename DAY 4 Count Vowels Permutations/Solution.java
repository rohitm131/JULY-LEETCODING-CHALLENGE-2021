class Solution {
    
    private Map<String, Long> map = new HashMap<>();
    private int MOD = 1000000007;
    
    public int countVowelPermutation(int n) {
        
        long total = 0;
        char[] charSet = new char[]{'a', 'e', 'i', 'o', 'u'};
        for(char c : charSet){
            total = (total + solve(n-1, c)) % MOD;
        }
        
        return (int)total;
        
    }
    
    public long solve(int remainingChar, char prevChar) {
        if(remainingChar == 0) return 1;
        String key = "" + remainingChar + prevChar;
        if(map.containsKey(key)) return map.get(key);
        long total = 0;
        
        switch(prevChar) {
            case 'a':
                total = (solve(remainingChar-1, 'e')) %MOD;
                break;
            case 'e':
                total = (solve(remainingChar-1, 'a') + solve(remainingChar-1, 'i')) %MOD;
                break;
            case 'i':
                total = (solve(remainingChar - 1,'a') + solve(remainingChar - 1, 'e') + solve(remainingChar - 1, 'o') + solve(remainingChar - 1, 'u')) % MOD;
                break;
            case 'o':
                total = (solve(remainingChar - 1,'i') + solve(remainingChar - 1,'u')) % MOD;
                break;
            case 'u':
                total = (solve(remainingChar - 1,'a')) % MOD;
                break;
        }
        map.put(key, total);
        return total;
    }
    
}
