package logic_2;

public class Algo_2 {

	public static void main(String[] args) {

		System.out.println(loneSum(1, 2, 3));

	}

	public static int loneSum(int a, int b, int c) {
		  
		  if(a==b && a==c){
		    return 0;
		  }
		  if(a==b && a!=c){
		    return c;
		  }
		  
		  if(b==c && a!=c){
		    return a;
		  }
		  
		  if(a==c && b!=a){
		    return b;
		  }
		  
		  return a+b+c;
		}

}
