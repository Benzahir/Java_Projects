package array_1;

public class Algo_12 {

	public static void main(String[] args) {
		
		int[] arr1 = {1, 2};
		int[] arr2 = {3, 4};
		
		int[] arr = biggerTwo(arr1, arr2);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public  static int[] biggerTwo(int[] a, int[] b) {
		  
		  int suma=0;
		  int sumb=0;
		  
		  suma=a[0]+a[1];
		  sumb=b[0]+b[1];
		  if(suma > sumb){
		    return a;
		  }
		   if(suma < sumb){
		    return b;
		  }
		  return a;
		}


}
