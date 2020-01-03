package logic_1;

public class Algo_4 {
	
	public static void main(String[] args) {
		 
		System.out.println(old35(3));
	}
	public static boolean old35(int n) {
		  if(n%3==0 && n%5!=0 || n%5==0 && n%3!=0){
		    return true;
		  }
		  return false;
		}

}
