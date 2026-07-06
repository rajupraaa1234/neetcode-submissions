class Solution {
    public int evalRPN(String[] str) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<str.length;i++){
            String token = str[i];
            if(token.equals("+")){
                if(s.size()>1){
                    s.push(s.pop() + s.pop());
                }
            }else if(token.equals("*")){
                if(s.size()>1){
                    s.push(s.pop() * s.pop());
                }
            }else if(token.equals("-")){
                if(s.size()>1){
                    int num1=s.pop();
                    int num2 = s.pop();
                    s.push(num2 - num1);
                }
            }else if(token.equals("/")){
                if(s.size()>1){
                    int num1=s.pop();
                    int num2 = s.pop();
                    if(num1 == 0 || num2 == 0){
                        s.push(0);
                    }else{
                        s.push(num2/num1);
                    }
                }
            }else{
                s.push(Integer.parseInt(token));
            }
        }
        if(s.isEmpty()){
            return 0;
        }else{
            return s.pop();
        }
    }
}
