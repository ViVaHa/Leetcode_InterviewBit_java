class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.get(val)!=null){
            return false;
        }else{
            int size = list.size();
            list.add(val);
            map.put(val, size);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        int ind = map.getOrDefault(val,-1);
        if(ind == -1) return false;
        Collections.swap(list,ind,list.size()-1);
        int swappedWith = list.get(ind);
        map.put(swappedWith,ind);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(list.size()==0){
            return -1;
        }
        Random rand = new Random();
        int randIndex =  rand.nextInt(list.size());
        return list.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
