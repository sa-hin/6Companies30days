class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int dp[]=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            dp[0]+=(i*nums[i]);
        }

        //[25,0,0,0]
        
        int ind=nums.length-1;
        int n=nums.length;
       int ans=dp[0];
       for(int i=1;i<dp.length;i++){
           dp[i]=sum+dp[i-1]-(n*nums[ind]);
           ind--;
           ans=Math.max(ans,dp[i]);
       }
       
       return ans;

    }

}