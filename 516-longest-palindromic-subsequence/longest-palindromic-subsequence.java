class Solution {
    public int longestPalindromeSubseq(String s) {
        String text1=s;
        StringBuilder str=new StringBuilder(s);
        String text2=str.reverse().toString();
        int m=text1.length();
        int n=text2.length();
        return lcs(text1,text2,m,n);
    }


     public int lcs(String s,String t,int m,int n){
        int[] prev=new int[n];
        
        for(int i=0;i<m;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                
                if(s.charAt(i)==t.charAt(j)){
                    int a=0;
                    if(i>0 && j>0){
                        a=prev[j-1];
                    }
                    curr[j]=1+a;
                }
                else{
                    int b=0;
                    int c=0;
                    if(i>0){
                        b=prev[j];
                    }
                    if(j>0){
                        c=curr[j-1];
                    }
                    curr[j]=0+Math.max(b,c);
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
}