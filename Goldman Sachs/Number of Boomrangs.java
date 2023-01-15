class Solution {
     public int distance(int a[],int b[]){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
    public int numberOfBoomerangs(int[][] points) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                int dist=distance(points[i],points[j]);
                map.put(dist,map.getOrDefault(dist,0)+1);
            }
        for(int val:map.values()){
            ans+=val*(val-1);
        }
       map.clear();
        }
         return ans;
    }
}