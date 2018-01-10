public class Insertion {
	public int[] sort(int arr[]){
		for(int i=1; i<arr.length; i++){
			int key = arr[i];
			for(int j=0; j<i; j++){
				if(arr[j]>arr[i]){
					for(int k=i; k>j; k--){
						arr[k]=arr[k-1];
					}
					arr[j] = key;
					j=i;
					break;
				}
			}
		}
		return arr;
	}
}
