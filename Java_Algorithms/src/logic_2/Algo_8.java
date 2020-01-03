package logic_2;

public class Algo_8 {

	public static void main(String[] args) {
		
		System.out.println(makeChocolate(4, 1, 9));

	}

	public static int makeChocolate(int small, int big, int goal) {
		  
		   
		  int b= goal/5;
		  int z=b*5;
		  
		  if(b>big){
		    z=big*5;
		  }
		  
		  if(z+small <goal){
		    return -1;
		  }
		  
		  return goal-z;

		  
		}

}
