package logic_2;

public class Algo_1 {

	public static void main(String[] args) {
		
		System.out.println(makeBricks(3, 1, 8));

	}
	
	public static boolean makeBricks(int small, int big, int goal) {
		   
		   int x= goal/5;
		   int y=goal%5;
		   int z=0;
		   
		   if(y<=small){
		     z=small;
		   }
		   
		   if(x>big){
		     x=big;
		   }
		   
		   if((x*5)+z>=goal){
		     return true;
		   }
		   
		   return false;
		}


}
