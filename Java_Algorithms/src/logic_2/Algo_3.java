package logic_2;

public class Algo_3 {

	public static void main(String[] args) {

		System.out.println(noTeenSum(1, 2, 3));

	}

	public static int noTeenSum(int a, int b, int c) {
		  
		  return fixTeen(a)+fixTeen(b)+fixTeen(c);

		}

		public static  int fixTeen(int n){
		    if(n==13 || n==14 || n==17 || n==18 || n==19){
		      return 0;
		    }
		    return n;
		}
}
