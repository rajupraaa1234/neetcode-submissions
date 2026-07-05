class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int maxF = 0;
        for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
           maxF = Math.max(maxF,map.get(ch));
           while(((i-left+1)-maxF) > k) {
             map.put(s.charAt(left),map.get(s.charAt(left))-1);
             left++;
           }
           max = Math.max(max,(i-left+1));
        }
        return max;
    }
}
