package logic_2;

public class Algo_6 {

	public static void main(String[] args) {
		 
		System.out.println(blackjack(21, 19));

	}
	
	public static int blackjack(int a, int b) {
		  
		  if(a<21 && b>21){
		    return a;
		  }
		  
		   if(a>21 && b<21){
		    return b;
		  }
		  
		   if(a>21 && b>21){
		    return 0;
		  }
		  if(Math.abs(a-21) < Math.abs(b-21)){
		    return a;
		  }
		  
		  return b;
		  
		}


}
