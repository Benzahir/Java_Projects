package array_1;

public class Algo_7 {

	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {4, 5, 6};
		 
		int[] arr = middleWay(arr1, arr2);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] middleWay(int[] a, int[] b) {
		  int i=0;
		  int[] c={i,i+1};
		 
		  c[0]=a[1];
		  c[1]=b[1];
		 
		 return c;
		}

}
