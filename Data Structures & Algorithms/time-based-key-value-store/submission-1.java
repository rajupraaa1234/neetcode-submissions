class TimeMap {

    class Pair{
        int time;
        String key;
        String value;
        Pair(int time,String k,String v){
            this.time = time;
            this.key = k;
            this.value = v;
        }
    }
    ArrayList<Pair> arr;
    public TimeMap() {
        arr = new ArrayList<>();
    }
    
    public void set(String key, String value, int timestamp) {
        arr.add(new Pair(timestamp,key,value));
        Collections.sort(arr, (a,b) -> a.time-b.time);
    }
    
    public String get(String key, int timestamp) {
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).time==timestamp && arr.get(i).key.equals(key)){
                return arr.get(i).value;
            }
        }
        for(int i=arr.size()-1;i>=0;i--){
            if(arr.get(i).time<timestamp && arr.get(i).key.equals(key)){
                return arr.get(i).value;
            }
        }
        return "";
    }
}
