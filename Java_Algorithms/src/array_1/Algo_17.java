package array_1;

public class Algo_17 {

	public static void main(String[] args) {
		
		int[] arr1 = {4, 5};
		int[] arr2 = {1, 2, 3};
		 
		 
		int[] arr = make2(arr1, arr2);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
 
	public static int[] make2(int[] a, int[] b) {
		  
		  int[] two= new int[2];
		  
		  if(a.length>=2){
		    two[0]=a[0];
		    two[1]=a[1];
		    return two;
		  }
		  if(a.length==1 && b.length>=1){
		    two[0]=a[0];
		    two[1]=b[0];
		    return two;
		  }
		  if(a.length==0 && b.length>=2){
		    two[0]=b[0];
		    two[1]=b[1];
		    return two;
		  }
		  
		  return two;
		}

}
