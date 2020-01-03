package array_2;

public class Algo_1 {

	public static void main(String[] args) {
		
		int[] arr = {1, 4, 1, 4};
		System.out.println(only14(arr));

	}
	
	public static boolean only14(int[] nums) {
	     boolean a= false;
	  
	  if(nums.length==0){
	    a=true;
	  }

	  for(int i=0; i<nums.length; i++){
	    if(nums[i]==1 || nums[i]==4 ) {
	      a=true;
	    }
	    else {
	      a=false;
	      break;
	    }
	    
	  }
	  
	   return a;
	}

}
