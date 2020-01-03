package logic_1;

public class Algo_10 {

	public static void main(String[] args) {

		System.out.println(sumLimit(2, 3));

	}

	public static int sumLimit(int a, int b) {
		  
		  int sum=a+b;
		 String sumString = String.valueOf(sum);
		 String aString = String.valueOf(a);
		 if(sumString.length()>aString.length()){
		   return a;
		 }
		   
		  return sum;
		}
}
