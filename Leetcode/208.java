class TrieNode{
    char val;
    TrieNode[] children;
    boolean isWord;
    public TrieNode(char val){
        this.val=val;
        this.children = new TrieNode[26];
        this.isWord=false;
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int index=0;
        TrieNode tempRoot = root;
        while(index<word.length() && tempRoot.children[word.charAt(index)-'a']!=null){
            tempRoot=tempRoot.children[word.charAt(index)-'a'];
            index+=1;
        }
        if(index==word.length()){
            tempRoot.isWord=true;
            return;
        }
        while(index<word.length()){
            tempRoot.children[word.charAt(index)-'a']=new TrieNode(word.charAt(index));
            tempRoot=tempRoot.children[word.charAt(index)-'a'];
            index+=1;
        }
        tempRoot.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tempRoot=root;
        if(word.length()==0){
            return true;
        }
        int index=0;
        while(index<word.length() && tempRoot!=null){
            tempRoot=tempRoot.children[word.charAt(index)-'a'];
            index+=1;
        }
        if(tempRoot==null){
            return false;
        }else{
            return tempRoot.isWord;
        }
        //return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode tempRoot=root;
        if(word.length()==0){
            return true;
        }
        int index=0;
        while(index<word.length() && tempRoot.children[word.charAt(index)-'a']!=null){
            tempRoot=tempRoot.children[word.charAt(index)-'a'];
            index+=1;
        }
        if(index==word.length()){
            return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
