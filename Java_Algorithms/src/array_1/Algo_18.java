package array_1;

public class Algo_18 {

	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {7, 8, 9};
		 
		int[] arr = front11(arr1, arr2);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}

	public static int[] front11(int[] a, int[] b) {
		  
		  int[] rs1=new int[2];
		   int[] rs2=new int[1];
		  if(a.length>=1 && b.length>=1){
		     rs1[0]=a[0];
		     rs1[1]=b[0];
		     return rs1;
		  }
		  if(a.length==0 && b.length>=1){
		     rs2[0]=b[0];
		      return rs2;
		  }
		  
		  if(b.length==0 &&  a.length>=1){
		     rs2[0]=a[0];
		      return rs2;
		  }
		 return a;
		}

}
