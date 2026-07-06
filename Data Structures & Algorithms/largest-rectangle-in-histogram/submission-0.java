class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        Stack<Integer> s = new Stack<>();
        s.push(0);
        left[0] = -1;
        right[n-1] = -1;
        for(int i=1;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = s.peek();
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            s.pop();
        }
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                right[i] = n;
            }else{
                right[i] = s.peek();
            }
            s.push(i);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            int width = right[i] - left[i] - 1;
            max = Math.max(max,arr[i]*width);
        }
        return max;
    }
}
