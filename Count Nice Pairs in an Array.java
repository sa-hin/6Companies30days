//nums[i]-rev(nums[i])=nums[j]-rev(nums[j])
//1,2,3,4,5
//1,2 1,3 1,4 1,5
//2,3 2,4 2,5
//3,4 3,5
//4,5
//(5*(5-1))/2 = 10
class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rev = Integer.parseInt(new StringBuilder().append(nums[i]).reverse().toString());
            int diff=nums[i]-rev;
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        long ans=0;
        long MOD = 1000000007;
        for(int value:map.values()){
            if(value==1) continue;
            ans=(ans+(long)value*(value-1)/2+MOD)%MOD;
        }

        return (int)ans;
    }
}