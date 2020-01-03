package array_1;

public class Algo_11 {

	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1,3};
		System.out.println(start1(arr1, arr2));

	}
	public static int start1(int[] a, int[] b) {
		  
		  int count =0;
		  if(a.length >=1){
		     if(a[0]==1){
		    count++;
		     
		    }
		  }
		 
		  if(b.length >=1){
		    if(b[0]==1){
		    count++;
		    
		   }
		  }
		  
		  return count;
	}
}
