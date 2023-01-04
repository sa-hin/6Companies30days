class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
     int n=nums.length;
     int dp[]=new int[nums.length];
     int prev[]=new int[nums.length];
     int ind=-1;
     int max=0;
     //dp = Till ith element max length of such subset 
     for(int i=0;i<n;i++){
         dp[i]=1;
         prev[i]=-1;
         for(int j=i-1;j>=0;j--){
             if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                 dp[i]=dp[j]+1;
                 prev[i]=j;
             }
         }
         if(dp[i]>max){
             max=dp[i];
             ind=i;
         }
     }
     List<Integer> res=new ArrayList<>();
     while(ind!=-1){
         res.add(nums[ind]);
         ind=prev[ind];
     } 
  return res;
    }
}