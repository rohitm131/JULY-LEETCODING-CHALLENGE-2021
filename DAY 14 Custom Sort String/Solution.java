class Solution {
    public String customSortString(String order, String str) {
        int freq[] = new int[26];
        
        for(char c : str.toCharArray()) {
            freq[c-'a']++;
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(char c : order.toCharArray()) {
            while(freq[c-'a'] > 0) {
                ans.append(c);
                freq[c-'a']--;
            }
        }
        
        for(int i=0; i<26; i++) {
            int f = freq[i];
            while(f > 0) {
                ans.append((char)(i+'a'));
                f--;
            }
        }
        
        return ans.toString();
    }
}
