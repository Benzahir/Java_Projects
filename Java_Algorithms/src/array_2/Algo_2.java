package array_2;

public class Algo_2 {

	public static void main(String[] args) {

		int[] arr = {1, 7, 1, 1, 7};
		System.out.println(has77(arr));

	}
	
	public static boolean has77(int[] nums) {
		  
		  boolean has=false;
		  
		  for(int i=0; i<nums.length-1; i++){
		    if(nums[i]==7 && nums[i+1]==7){
		      has= true;
		    }
		    if(i<=nums.length-3 && nums[i]==7 && nums[i+2]==7){
		      has=true;
		    }
		    
		  }
		  
		  
		     return  has;
		  
		}

}
