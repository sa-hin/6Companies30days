class Solution {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        comb(res,temp,k,n,1);
        return res;
    }

    public void comb(List<List<Integer>> res,List<Integer> temp,int k,int sum,int start){
        if(temp.size()==k && sum==0){
           // System.out.println(temp);
            res.add(new ArrayList<>(temp));
            //System.out.println(res);
            return;
        }

        for(int i=start;i<=9;i++){
            temp.add(i);
            comb(res,temp,k,sum-i,i+1);
            temp.remove(temp.size()-1);
        }
    }
}