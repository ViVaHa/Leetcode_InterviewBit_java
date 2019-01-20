class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0 || nums1.length==0){
            return;
        }
        int index1=m-1;
        int index2=n-1;
        int resIndex=nums1.length-1;
        while(index1>=0 && index2>=0){
            if(nums1[index1]>nums2[index2]){
                nums1[resIndex]=nums1[index1];
                index1-=1;
            }else{
                nums1[resIndex]=nums2[index2];
                index2-=1;
            }
            resIndex-=1;
        }
        if(index2>=0){
            while(index2>=0){
                nums1[resIndex]=nums2[index2];
                index2-=1;
                resIndex-=1;
            }
        }else if(index1>=0){
            nums1[resIndex]=nums1[index1];
            index1-=1;
            resIndex-=1;
        }
    }
}
