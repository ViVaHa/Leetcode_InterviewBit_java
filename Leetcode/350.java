class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i+=1;
                j+=1;
            }else if(nums1[i]<nums2[j]){
                i+=1;
            }else{
                j+=1;
            }
        }
        int res[] = new int[list.size()];
        i=0;
        for(int val:list){
            res[i]=val;
            i+=1;
        }
        return res;
    }
}
