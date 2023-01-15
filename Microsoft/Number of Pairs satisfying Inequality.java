class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n=nums1.length;

        long nums[]=new long[n];
        for(int i=0;i<nums1.length;i++){
            nums[i]=nums1[i]-nums2[i];
        }
      long temp[]=Arrays.copyOf(nums,n);
      return mergeSort(nums,temp,0,n-1,diff);

    }

    public static long mergeSort(long nums[],long temp[],int start,int end,int diff){
        if(start==end) return 0;
        int mid=start+(end-start)/2;
        long res=0L;
        res+=mergeSort(nums,temp,start,mid,diff);
        res+=mergeSort(nums,temp,mid+1,end,diff);
        res+=merge(nums,temp,start,mid,end,diff);

        return res;
    }
 
 //nums = [1,0,4]
 //start =0 end = 2 mid =(start+end)/2 = 1
 //nums1[i]-nums2[i]<=nums1[j]-nums2[j]+diff
 //nums[i]<=nums[j]+diff
   public static long merge(long nums[],long temp[],int start,int mid,int end,int diff){ 
    
    long res=0L;

    for(int i=start,j=mid+1;i<=mid && j<=end;i++){
        while(j<=end && nums[i]>nums[j]+diff) j++;
        res+=(end-j+1);
    }
 
 //Standard Merge Sorting 
    for(int i=start,j=mid+1,k=start;i<=mid || j<=end;k++){
       if(j>end  || (i<=mid && nums[i]<nums[j])){
           temp[k]=nums[i++];
       }
       else {
           temp[k]=nums[j++];
       }
    }

     System.arraycopy(temp,start,nums,start,end-start+1);

    return res;

   }  

}