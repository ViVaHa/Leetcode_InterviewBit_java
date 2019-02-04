class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versionsA = version1.split("\\.");
        String[] versionsB = version2.split("\\.");
        int minLength = Math.min(versionsA.length,versionsB.length);
        int index=0;
        while(index<minLength){
            int val1 = Integer.parseInt(versionsA[index]);
            int val2 = Integer.parseInt(versionsB[index]);
            if(val1>val2){
                return 1;
            }else if(val1<val2){
                return -1;
            }
            index+=1;
        }
        for(int i=index;i<versionsA.length;i++){
            if(Integer.parseInt(versionsA[i])!=0){
                return 1;
            }
        }
        for(int i=index;i<versionsB.length;i++){
            if(Integer.parseInt(versionsB[i])!=0){
                return -1;
            }
        }
        return 0;
    }
}
