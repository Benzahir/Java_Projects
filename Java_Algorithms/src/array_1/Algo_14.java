package array_1;

public class Algo_14 {

	public static void main(String[] args) {
		
		
		int[] nums = {1, 2, 3, 4, 5};
		int[] arr = midThree(nums);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] midThree(int[] nums) {
		  int[] mid= new int[3];
		  if(nums.length>=3){
		    mid[0]=nums[(nums.length/2)-1];
		    mid[1]=nums[nums.length/2];
		    mid[2]=nums[(nums.length/2)+1];
		    return mid;
		    
		  }
		  return nums;
		}
}
