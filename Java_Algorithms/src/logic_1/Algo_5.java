package logic_1;

public class Algo_5 {

	public static void main(String[] args) {
		
		System.out.println(nearTen(12));

	}

	public static boolean nearTen(int num) {
		  
		   int div=num%10;
		    if(div<=2 || div>=8){
		      return true;
		    }
		    return false;
		}

}
