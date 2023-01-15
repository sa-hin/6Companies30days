class Solution {
  public boolean isPossible(int[] A) {        
      Map<Integer,Integer> left=new HashMap<>();
      Map<Integer,Integer> end=new HashMap<>();

      for(int e:A) left.put(e,left.getOrDefault(e,0)+1);

      for(int a:A){
          if(left.get(a)<=0) continue;
          left.put(a,left.get(a)-1);

          //put a in existing subsequence
           if(end.containsKey(a-1) && end.get(a-1)>0){
               end.put(a-1,end.get(a-1)-1);
               end.put(a,end.getOrDefault(a,0)+1);
               continue;
           }

          //put a in new subsequence
          if(left.containsKey(a+1) && left.get(a+1)>0 && left.containsKey(a+2) && left.get(a+2)>0) {
              left.put(a+1,left.get(a+1)-1);
              left.put(a+2,left.get(a+2)-1);
              end.put(a+2,end.getOrDefault(a+2,0)+1);
              continue;
          }

          return false;
      }
      return true;

    }
}