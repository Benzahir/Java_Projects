package logic_1;

public class Algo_8 {
	
	public static void main(String[] args) {
		 
		System.out.println(withoutDoubles(2, 3, true));
	}
	
	public static int withoutDoubles(int die1, int die2, boolean noDoubles) {
		  
		  if(die1==die2 && die1==6 && noDoubles==true ){
		    return die1+1;
		  }
		  if(die1==die2 && noDoubles==true){
		    return 1+die1+die2;
		  }
		  return die1+die2;
		  
		}

}
