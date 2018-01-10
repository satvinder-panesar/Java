
public class Quick {
	public int[] sort(int arr[], int si, int ei){
		int pivot=arr[ei];
		int pi=ei;
		int li=-1,ri=-1;
		int temparr[];
		for(int i=si; i<ei; i++){
			if(arr[i]>pivot){
				li=i;
				break;
			}
		}
		for(int j=ei-1; j>=0; j--){
			if(arr[j]<pivot){
				ri=j;
				break;
				 
			}
		}
		if(li!=-1 && ri!=-1 && li<ri){
			int temp=arr[li];
			arr[li]=arr[ri];
			arr[ri]=temp;
		}else if(li!=-1){
			int temp=arr[li];
			arr[li]=arr[ei];
			arr[ei]=temp;
			pi=li;
			if(pi>1)
				temparr = sort(arr, si, pi-1);
			if(pi<ei-1)
			temparr = sort(arr, pi+1, ei);
		}else{
			if(pi>1)
			temparr = sort(arr, si, pi-1);
		}
		return arr;			
	}

}
