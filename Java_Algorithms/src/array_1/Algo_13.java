package array_1;

public class Algo_13 {

	public static void main(String[] args) {
		
		 

		int[] nums = {1, 2, 3, 4};
		int[] arr = swapEnds(nums);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] swapEnds(int[] nums) {
		  int k= nums[0];
		  int j= nums[nums.length-1];
		 
		  if(nums.length>=1){
		    nums[0]=j;
		    nums[nums.length-1]=k;
		    return nums;
		  }
		  return nums;
		  
		}

}
