// [2,1,2]
// [1,2,2]
// [2,0,2]

// 0 -> 1 (G)
// 1 -> 0 (G)
// 2 -> 1  (B)

// 2 -> G 
// 1 -> B   Lie - 0 B 
// 2B 1G

// 2 -> B Truth => 1 B Truth 0 G 1 G     Lie 0 B Truth 1 G   Lie 1 B =>0 G  
// Lie => 1 G => 0 G (2 G)

//000 =>0 
//001 =>1
//010 =>2
//011 =>3
//010 =>4
//101 =>5
//110 =>6 =>2 G =>0 G 1 G 2 B
//111 =>7 =>3 G

class Solution {
    public int maximumGood(int[][] statements) {
        
        int n=statements.length;
        int max=0;
        for(int i=0;i<(1<<n);i++) {
            if(valid(i,statements,n)) {
                int ans=Integer.bitCount(i);
                max=Math.max(max,ans);
            }
        }
        return max;
    }
    public static boolean valid(int mask,int a[][],int n) {
        for(int i=0;i<n;i++){
            if((mask & (1<<(n-i-1)))==0) continue;
            for(int j=0;j<n;j++){
                if(a[i][j]==2) continue;
                if((a[i][j]==1 && (mask & (1<<(n-j-1)))==0) ||(a[i][j]==0 && (mask & (1<<(n-j-1)))>0)) return false;
            }
        }
        return true;
    }
}