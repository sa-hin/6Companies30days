class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
       int arr[]={dist(p1,p2),dist(p1,p3),dist(p1,p4),dist(p2,p3),dist(p2,p4),
       dist(p3,p4)};

       Set<Integer> set=new HashSet<>();

       for(int e:arr) set.add(e);

       return !set.contains(0) && set.size()==2;

    }

    public int dist(int a[],int b[]){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}