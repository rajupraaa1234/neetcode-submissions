class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int res[] = new int[n-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        int left = 0;
        int index =0;
        for(int i=k;i<=n;i++){
            res[index++] = pq.peek();
            pq.remove(arr[left++]);
            if(i<n)
              pq.add(arr[i]);
        }

        return res;
    }
}
