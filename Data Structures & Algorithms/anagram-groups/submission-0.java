class Solution {
    public String getSortString(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++){
            String modifiedString = getSortString(strs[i]);
            System.out.println(modifiedString);
            map.computeIfAbsent(modifiedString,k->new ArrayList<>()).add(strs[i]);
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
