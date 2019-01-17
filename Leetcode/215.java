class MaxHeap
{
	int size;
	int arr[];
	public MaxHeap(int size){
		this.size=0;
		arr=new int[size];
	}
	public void maxHeapify(int pos){
		int l=left(pos);
		int r=right(pos);
		int largest=pos;
		if(l<size){
			if(arr[l]>arr[largest]){
				largest=l;
			}
		}
		if(r<size){
			if(arr[r]>arr[largest]){
				largest=r;
			}
		}
		if(largest!=pos){
			int temp=arr[pos];
			arr[pos]=arr[largest];
			arr[largest]=temp;
			maxHeapify(largest);
		}
	}
	public void addKey(int val){
		if(size<arr.length){
			arr[size]=val;
			int i=size;
			size+=1;
			while(arr[parent(i)]<arr[i]){
				int temp=arr[parent(i)];
				arr[parent(i)]=arr[i];
				arr[i]=temp;
				i=parent(i);
			}
		}else{
			System.out.println("Capacity is full");
		}
		
	}
	public int extractMax(){
		if(size==0){
			
			return-1;
		}
		int val=arr[0];
		arr[0]=arr[size-1];
		size-=1;
		maxHeapify(0);
		return val;
	}
	public int parent(int pos){
		return (pos)/2;
	}
	public int left(int pos){
		return 2*pos;
	}
	public int right(int pos){
		return pos*2+1;
	}
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        MaxHeap heap = new MaxHeap(nums.length);
        for(int n:nums){
            heap.addKey(n);
        }
		for(int i=0;i<k-1;i++){
            int x=heap.extractMax();
        }
        return heap.extractMax();
    }
}
