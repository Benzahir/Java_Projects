package array_1;

public class Algo_1 {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 6};
		System.out.println(firstLast6(arr));

	}
	
	
	public static boolean firstLast6(int[] nums) {
		  
		  if(nums.length >= 1){
		    for(int i=0; i< nums.length ; i++){
		      if(nums[0]==6 || nums[nums.length-1]==6){
		        return true;
		      }
		    }
		  }
		  return false;
		}

}
