package logic_1;

public class Algo_7 {

	public static void main(String[] args) {
		
		System.out.println(inOrderEqual(2, 5, 11, false));

	}
	
	public static boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
		  
		  boolean boo=false;
		  if((a<b && b <c && a!=b && b!=c) || (equalOk==true && a<=b && b<=c)){
		    boo= true;
		  }
		  
		  return boo;
		}

}
