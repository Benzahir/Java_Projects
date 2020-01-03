package array_1;

public class Algo_3 {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {7, 3};
		
		System.out.println(commonEnd(arr1, arr2));

	}
	
	public static boolean commonEnd(int[] a, int[] b) {
		  
		  
		  if(a.length>=1 && b.length>=1){
		    
		    if(a[0]==b[0] || a[a.length-1]==b[b.length-1]){
		      return true;
		    }
		  }
		  return false;
		}

}
