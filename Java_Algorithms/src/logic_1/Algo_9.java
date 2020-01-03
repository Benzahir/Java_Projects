package logic_1;

public class Algo_9 {

	public static void main(String[] args) {

		System.out.println(blueTicket(9, 1, 0));

	}
	
	public static int blueTicket(int a, int b, int c) {
		  
		  if(a+b==10 || b+c==10 || a+c==10){
		    return 10;
		  }
		  
		  if(a+b>=b+c+10 || a+b>=a+c+10){
		    return 5;
		  }
		  return 0;
		}

}
