class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((word1,word2)->{
            return map.get(word1)==map.get(word2) ? word1.compareTo(word2) : map.get(word2)-map.get(word1);
        });
        for(Map.Entry<String,Integer>entry : map.entrySet()){
            //System.out.println(entry.getKey());
            queue.offer(entry.getKey());
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(queue.poll());
        }
        return res;
    }
}
