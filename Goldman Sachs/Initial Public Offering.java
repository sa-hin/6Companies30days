//1st proj - 0 , 1
//2nd proj - 1,  2
//3rd proj - 1,  3

//w =0+1=1+3=4
//k = 2

//total profits maximized

//1,3

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<int[]> cap=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        PriorityQueue<int[]> pro=new PriorityQueue<>((a,b)->(b[1]-a[1]));
        
        for(int i=0;i<profits.length;i++){
            cap.add(new int[]{capital[i],profits[i]});
        }
        //cap=> {[0,1],[1,2],[1,3]}
        for(int i=0;i<k;i++){
            while(!cap.isEmpty()&&cap.peek()[0]<=w) pro.add(cap.poll());
            if(!pro.isEmpty())
            w+=pro.poll()[1];
        }
        return w;
    }
}