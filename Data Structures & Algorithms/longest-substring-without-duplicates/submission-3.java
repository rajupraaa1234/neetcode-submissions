class Solution {
    public boolean isValid(String str){
        Set<Character> s = new HashSet<>();
        for(int i=0;i<str.length();i++){
            s.add(str.charAt(i));
        }
        return str.length() == s.size();
    }
    public int lengthOfLongestSubstring(String str) {
        int max = 0;
        if(str.length() >=1 ){
            max = 1;
        }
        if(str.length() == 1 && str.charAt(0) == ' ') return 1;
        if(str.length() == 1) return 1;
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                String newStr = str.substring(i,j+1);
                if(isValid(newStr)){
                    max = Math.max(max,newStr.length());
                }
            }
        }
        return max;
    }
}
