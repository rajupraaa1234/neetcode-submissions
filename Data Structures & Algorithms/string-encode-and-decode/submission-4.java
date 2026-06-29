class Solution {

    String sign = "123456789w343536345435345345";

    public String encode(List<String> strs) {
       int n = strs.size();
       if(strs.size() == 0) return "";
       StringBuilder sb = new StringBuilder();
       sb.append(n);
       sb.append(sign);
       for(int i=0;i<n;i++){
          if(strs.get(i) == ""){
            sb.append("$");
          }else{
            sb.append(strs.get(i));
          }
          sb.append(sign);
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
        String arr[] = str.split(sign);
        List<String> ans = new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i].equals("$")){
                ans.add("");
            }else{
              ans.add(arr[i]);
            }   
        }
        // if(ans.size() == 0){
        //     ans.add("");
        // }
        return ans;
    }
}
