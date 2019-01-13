public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int requiredRooms=1;
        int maxReqRooms=1;
        Collections.sort(arrive);
        Collections.sort(depart);
        int i=1;
        int j=0;
        int n=arrive.size();
        while(i<n && j<n){
            if(arrive.get(i)<depart.get(j)){
                requiredRooms+=1;
                i+=1;
            }else{
                j+=1;
                requiredRooms-=1;
            }
            if(requiredRooms>maxReqRooms){
                maxReqRooms=requiredRooms;
            }
        }
        return K>=maxReqRooms;
    }
}

