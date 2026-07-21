class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        ArrayList<String> board=new ArrayList<>();
        String s=".".repeat(n);
        for(int i=0;i<n;i++){
            board.add(s);
        }
        int col=0;
        NQueen(result,col,board,n);
        return result;
    }

    boolean canIPlaceQueen(int row,int col,ArrayList<String> board,int n){

         // same row (left side)
        for(int i=col-1;i>=0;i--){
            if(board.get(row).charAt(i)=='Q'){
                return false;
            }
        }

        // leftdowndiagonal
       int i=row+1;
       int j=col-1;
       while(i<n && j>=0){
        if(board.get(i).charAt(j)=='Q'){
            return false;
        }
        i++;
        j--;
       }

        // leftupdiagonal
       int lui=row-1;
       int luj=col-1;
       while(lui>=0 && luj>=0){
        if(board.get(lui).charAt(luj)=='Q'){
            return false;
        }
        lui--;
        luj--;
       }

       return true;
        
    }



    void NQueen(List<List<String>> result,int col,ArrayList<String> board,int n){
        if(col==n){
            result.add(new ArrayList<>(board));
            return;
        }

        for(int row=0;row<n;row++){
           if(canIPlaceQueen(row,col,board,n)){
            StringBuilder sb=new StringBuilder(board.get(row));
            sb.setCharAt(col,'Q');
            board.set(row,sb.toString());
            NQueen(result,col+1,board,n);
            sb.setCharAt(col,'.');
            board.set(row,sb.toString());
           }
        }
    }
}