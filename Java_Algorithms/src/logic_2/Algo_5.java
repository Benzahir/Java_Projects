package logic_2;

public class Algo_5 {

	public static void main(String[] args) {

		System.out.println(closeFar(1, 2, 10));

	}
	
	public static boolean closeFar(int a, int b, int c) {
		  
		  if(Math.abs(a-b)<=1){
		    if(Math.abs(c-b)>=2 && Math.abs(c-a)>=2){
		      return true;
		    }
		  }
		  
		  if(Math.abs(a-c)<=1){
		    if(Math.abs(b-a)>=2 && Math.abs(b-c)>=2){
		      return true;
		    }
		  }
		  
		  return false;
		}


}
