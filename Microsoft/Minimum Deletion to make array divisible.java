class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);

        int g=numsDivide[0],temp;
        for(int a:numsDivide){
            while(a>0) {
                temp=g%a;
                g=a;
                a=temp;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(g>=nums[i]){
                if(g%nums[i]==0) return i;
            }
        }

        return -1;
    }
}