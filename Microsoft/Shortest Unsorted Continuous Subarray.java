class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n=nums.length;
        int temp[]=new int[n];

        for(int i=0;i<n;i++) {
            temp[i]=nums[i];
        }

        Arrays.sort(temp);

        if(Arrays.equals(temp,nums)) {
            return 0;
        }

        int begin=0;
        int end=n-1;

        while(temp[begin]==nums[begin]) begin++;
        while(temp[end]==nums[end]) end--;

        return (end-begin+1);
    }
}

// Temp => 2 4 6 8 9 10 15
// Nums => 2 6 4 8 10 9 15

//begin = 2 end =5 len = 4