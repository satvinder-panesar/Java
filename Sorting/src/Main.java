import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		System.out.println("Welcome\nPlease enter array size");
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			System.out.println("Enter no at index "+(i+1));
			arr[i]=sc.nextInt();
		}
		System.out.println("Sorted!");
		//int sa[] = new Bubble().sort(arr);
		//int sa[] = new Selection().sort(arr);
		//int sa[] = new Insertion().sort(arr);
		int sa[] = new Quick().sort(arr,0,arr.length-1);
		
		for(int i=0; i<n; i++){
			System.out.println(sa[i]);
		}
	}

}
