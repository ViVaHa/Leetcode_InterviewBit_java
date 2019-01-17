class HeapNode{
    int row;
    int col;
    int val;
    public HeapNode(int row, int col, int val){
        this.row=row;
        this.col=col;
        this.val=val;
    }
}
class MaxHeap
{
	int size;
	HeapNode arr[];
	public MaxHeap(int size){
		this.size=0;
		arr=new HeapNode[size];
	}
	public void maxHeapify(int pos){
		int l=left(pos);
		int r=right(pos);
		int largest=pos;
		if(l<size){
			if(arr[l].val>arr[largest].val){
				largest=l;
			}
		}
		if(r<size){
			if(arr[r].val>arr[largest].val){
				largest=r;
			}
		}
		if(largest!=pos){
			HeapNode temp=arr[pos];
			arr[pos]=arr[largest];
			arr[largest]=temp;
			maxHeapify(largest);
		}
	}
	public void addKey(HeapNode node){
		if(size<arr.length){
			arr[size]=node;
			int i=size;
			size+=1;
			while(arr[parent(i)].val<arr[i].val){
				HeapNode temp=arr[parent(i)];
				arr[parent(i)]=arr[i];
				arr[i]=temp;
				i=parent(i);
			}
		}else{
			System.out.println("Capacity is full");
		}
		
	}
	public HeapNode extractMax(){
		if(size==0){
			return null;
		}
		HeapNode node = arr[0];
		arr[0]=arr[size-1];
		size-=1;
		maxHeapify(0);
		return node;
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
    public int kthSmallest(int[][] matrix, int k) {
        MaxHeap h = new MaxHeap(matrix[0].length);
        int lastRow=matrix.length-1;
        k=matrix.length*matrix[0].length-k;
        for(int i=0;i<matrix[0].length;i++){
            h.addKey(new HeapNode(lastRow,i,matrix[lastRow][i]));
        }
        for(int i=0;i<k;i++){
            HeapNode node = h.extractMax();
            int row=node.row;
            int col=node.col;
            if(row>0){
                h.addKey(new HeapNode(row-1,col,matrix[row-1][col]));
            }else{
                h.addKey(new HeapNode(-1,-1,Integer.MIN_VALUE));
            }
        }
        return h.extractMax().val;
    }
}
