package array_1;

public class Algo_16 {

	public static void main(String[] args) {
		
		int[] arr = {1, 3, 4, 5};
		System.out.println(unlucky1(arr));

	}
	
	public static boolean unlucky1(int[] nums) {

		if(nums.length >=2){
		  if(nums[0]==1 && nums[1]==3 || nums[1]==1 && nums[2]==3 || nums[nums.length-2]==1 && nums[nums.length-1]==3){
		      return true;
		    }
		}
		    
		  
		  return false;
		}

}
