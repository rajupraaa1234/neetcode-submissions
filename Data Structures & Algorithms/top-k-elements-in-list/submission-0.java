class Solution {
    class Pair{
        int num;
        int freq;
        Pair(int a,int b){
            num = a;
            freq = b;
        }
    }
    public int[] topKFrequent(int[] arr, int k) {
        PriorityQueue<Pair> maxPq = new PriorityQueue<Pair>((a,b) -> b.freq - a.freq);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            maxPq.add(new Pair(num,freq));
        }
        int ans[] = new int[k];
        int i=0;
        while(k-->0 && !maxPq.isEmpty()){
            ans[i++] = maxPq.poll().num;
        }
        return ans;
    }
}
