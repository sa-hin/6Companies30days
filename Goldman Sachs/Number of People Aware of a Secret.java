class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[]=new long[n+1];
        dp[1]=1;
        int time = 2;
        long peopleKnowingSecret = 0;
        long MOD = (long)(1e9+7);
        while(time<=n){
            if(time-delay>0) {
              peopleKnowingSecret = (peopleKnowingSecret+dp[time-delay]+MOD)%MOD;
            }
            if(time-forget>0){
            peopleKnowingSecret = (peopleKnowingSecret-dp[time-forget]+MOD)%MOD;
            }
            dp[time]=peopleKnowingSecret;
            time++;
        }
         long res=0;
        for(int i=n-forget+1;i<=n;i++) 
        res=(res+dp[i])%MOD;

        return (int)(res%MOD);
    }
}