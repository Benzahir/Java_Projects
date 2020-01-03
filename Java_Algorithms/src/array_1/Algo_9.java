package array_1;

public class Algo_9 {

	public static void main(String[] args) {
		
		int[] nums = {4, 5, 6};
		int[] arr = makeLast(nums);

		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] makeLast(int[] nums) {
		  
		  int[] db=new int[nums.length*2];
		  
		  if(nums.length >=1){
		   
		    db[db.length-1]=nums[nums.length-1];
		    return db;
		    
		  }
		  return db;
		}
}
