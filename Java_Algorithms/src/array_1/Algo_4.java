package array_1;

public class Algo_4 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3};
		int[] arr = rotateLeft3(nums);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] rotateLeft3(int[] nums) {
		  
		  int k = nums[0];
		  int l = nums[1];
		  int m = nums[2];
		  
		      nums[0]= l ;
		      nums[1]= m; 
		      nums[2]= k;
		    
		  return nums;
		   
		}
}
