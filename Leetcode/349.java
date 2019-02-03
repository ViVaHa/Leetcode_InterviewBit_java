class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ind1=0;
        int ind2=0;
        List<Integer> intersection = new ArrayList<>();
        while(ind1<nums1.length && ind2<nums2.length){
            while(ind1+1<nums1.length && nums1[ind1]==nums1[ind1+1]){
                ind1+=1;
            }
            while(ind2+1<nums2.length && nums2[ind2]==nums2[ind2+1]){
                ind2+=1;
            }
            if(nums1[ind1]==nums2[ind2]){
                intersection.add(nums1[ind1]);
                ind1+=1;
                ind2+=1;
            }else if(nums1[ind1]<nums2[ind2]){
                ind1+=1;
            }else{
                ind2+=1;
            }
        }
        int[] retVal = new int[intersection.size()];
        int index=0;
        for(int i=0;i<retVal.length;i++){
            retVal[i] = intersection.get(i);
        }
        return retVal;
    }
}
