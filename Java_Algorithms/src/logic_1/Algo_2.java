package logic_1;

public class Algo_2 {

	public static void main(String[] args) {
		
		System.out.println(in1To10(5, false));

	}
	
	public static boolean in1To10(int n, boolean outsideMode) {
		  if(n>=1 && n<=10 && outsideMode==false){
		    return true;
		  }
		  if((n<=1 || n>=10) && outsideMode==true){
		    return true;
		  }
		  return false;
		}

}
