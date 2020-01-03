package array_1;

public class Algo_10 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3};
		int[] arr = fix23(nums);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] fix23(int[] nums) {

		if(nums.length ==3){
		  for(int i=0; i<=2;i++){
		    if(nums[i]==2 && nums[i+1]==3){
		      nums[i+1]=0;
		      return nums;
		    }
		  }
		}
		  
		 return nums;
		}

}
