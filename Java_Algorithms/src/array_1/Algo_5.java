package array_1;

public class Algo_5 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3};
		int[] arr = maxEnd3(nums);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] maxEnd3(int[] nums) {
		  
		  
		  if(nums[0] > nums[nums.length-1]){
		    nums[0]=nums[0];
		    nums[1]=nums[0];
		    nums[2]=nums[0];
		    
		  }
		  
		  if(nums[0] <= nums[nums.length-1]){
		    nums[0]=nums[nums.length-1];
		    nums[1]=nums[nums.length-1];
		    nums[2]=nums[nums.length-1];
		    
		    return nums;
		    
		  }
		  return nums;
		  
		}
}
