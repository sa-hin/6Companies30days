class Solution {
    public static int[] KMP(String str){
        int n=str.length();
        int lps[]=new int[n];
        int j=0;
        for(int i=1;i<n;){
            if(str.charAt(i)==str.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }
            else {
                if(j!=0){
                    j=lps[j-1];
                }
                else {
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public String longestPrefix(String s) {
        int lps[]=KMP(s);
        return s.substring(0,lps[lps.length-1]);
    }
}