package array_1;

public class Algo_15 {

	public static void main(String[] args) {
		
		
		int[] nums = {1, 2, 3};
		int[] arr = frontPiece(nums);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
 
	public static int[] frontPiece(int[] nums) {
		  
		  int[] two= new int[2];
		  if(nums.length>=2){
		    two[0]=nums[0];
		    two[1]=nums[1];
		    return two;
		  }
		  return nums;
		}

}
