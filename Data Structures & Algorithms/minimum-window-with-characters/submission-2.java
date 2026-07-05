class Solution {
    public boolean isValid(String s,String t){
       int sarr[] = new int[100];
       int tarr[] = new int[100];
       for(int i=0;i<s.length();i++){
          sarr[s.charAt(i)-'A']++;
       }
       for(int i=0;i<t.length();i++){
          tarr[t.charAt(i)-'A']++;
       }
       for(int i=0;i<100;i++){
          if(sarr[i] < tarr[i]) return false;
       }
       return true;
    }
    public String minWindow(String s, String t) {
        String res = "";
        if(s.equals(t)) return s;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String ch = s.substring(i,j+1);
                if(isValid(ch,t)){
                    if(res.length() > ch.length() || res.equals("")){
                        res = ch;
                    }
                }
            }
        }
        return res;
    }
}
