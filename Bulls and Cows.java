class Solution {
    public String getHint(String secret, String guess) {
        int bull=0;
        int cow=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) {
                bull++;
            }
        }

        int freq[]=new int[10];
         
        for(int i=0;i<guess.length();i++){
            freq[guess.charAt(i)-'0']++;
        }
       // [1,3]
       //[0,3]

       //[1,2,0,1]
       for(int i=0;i<guess.length();i++){
           if(freq[secret.charAt(i)-'0']!=0){
               freq[secret.charAt(i)-'0']--;
               cow++;
           }
       }
       
       System.out.println(cow);
       System.out.println(bull);
       cow = cow-bull;
       String res= bull+""+ "A"+ cow+""+"B";
       
       return res;
    }
}