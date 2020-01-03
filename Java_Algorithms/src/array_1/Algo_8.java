package array_1;

public class Algo_8 {

	public static void main(String[] args) {
	 
		int[] nums = {1, 2, 6};
		int[] arr = makeEnds(nums);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] makeEnds(int[] nums) {
		  int i=0;
		  int[] news={i,i+1};
		  if(nums.length >1){
		    news[i]=nums[0];
		    news[i+1]=nums[nums.length-1];
		    return news;
		    
		  }
		  if(nums.length ==1){
		    news[i]=nums[0];
		    news[i+1]=nums[0];
		    return news;
		  }
		  return nums;
		}
}
