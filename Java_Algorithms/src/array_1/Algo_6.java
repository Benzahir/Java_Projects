package array_1;

public class Algo_6 {
	
	public static void main(String[] args) {
		
        int[] arr = {1, 2, 3};
		System.out.println(sum2(arr));


	}
	
	public static int sum2(int[] nums) {
		  
		  int sum=0;
		  if(nums.length >=2){
		    for(int i=0; i<2; i++){
		      sum+=nums[i];
		      
		    }
		    return sum;
		  }
		  
		  if(nums.length ==1){
		    return nums[0];
		  }
		   return 0;
		}
}
