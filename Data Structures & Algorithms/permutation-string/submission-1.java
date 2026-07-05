class Solution {

    public boolean isValid(String temp,String s1){
        int arr1[]=new int[26];
        int arr2[]=new int[26];
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[temp.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length()>s2.length()) return false;
        int len = s1.length();
        for(int i=0;i<=s2.length()-len;i++){
            String temp = s2.substring(i,i+len);
            if(isValid(temp,s1)) return true;
        }
        return false;
    }
}
