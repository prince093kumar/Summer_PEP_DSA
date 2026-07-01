class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        backtrack(digits,res,str,map,0);
        return res;
    }

    public void backtrack(String digits,List<String> res,StringBuilder ans,HashMap<Character,String>map,int idx){
        if(digits.length()==0){
            return ;
        }
        if(idx==digits.length()){
            res.add(ans.toString());
            return;
        }

        String letter=map.get(digits.charAt(idx));
        for(int i=0;i<letter.length();i++){
            ans.append(letter.charAt(i));
            backtrack(digits,res,ans,map,idx+1);
            ans.deleteCharAt(ans.length()-1);
        }
    }
}