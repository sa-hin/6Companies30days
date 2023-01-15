class Solution {
    public int numberOfSubstrings(String s) {
        
        
        int freq[]={0,0,0};
        int res=0,j=0;
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
            //{1,1,1}
            while(freq[0]>0 && freq[1]>0 && freq[2]>0) {
                --freq[s.charAt(j++)-'a'];
            }
            res+=j;
        }
        return res;
    }
}