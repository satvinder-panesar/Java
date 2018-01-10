public class Selection {
	public int[] sort(int arr[]){
		for(int i=0; i<arr.length-1; i++){
			int minindex = i;
			int minvalue = arr[i];
			for(int j=i+1; j<arr.length; j++){
				if(minvalue>arr[j]){
					minvalue=arr[j];
					minindex=j;
				}
			}
			int temp;
			temp=arr[i];
			arr[i]=arr[minindex];
			arr[minindex]=temp;
		}
		return arr;
	}
}
