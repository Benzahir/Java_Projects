package array_1;

public class Algo_2 {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3};
		System.out.println(sameFirstLast(arr));

	}
	
	public static boolean sameFirstLast(int[] nums) {
		  
		  if(nums.length >=1){
		    for(int i=0; i<nums.length; i++){
		      if(nums[0]==nums[nums.length-1]){
		        return true;
		      }
		    }
		}
		return false;
		}

}
