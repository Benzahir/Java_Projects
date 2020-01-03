package logic_2;

public class Algo_7 {

	public static void main(String[] args) {
		
		System.out.println(evenlySpaced(2, 4, 6));

	}

	public static boolean evenlySpaced(int a, int b, int c) {
		  
		  int min = Math.min(a,b);
		  int max = Math.max(a,b);
		  int medium = 0;
		  
		  if(max<c){
		    medium=max;
		    max=c;
		  }
		  else if(min<c){
		    medium=c;
		  }
		  else{
		    min=c;
		    medium=a;
		  }
		  if(Math.abs(medium-min)== Math.abs(medium-max)){
		    return true;
		  }
		 
		  return false;
		}

}
