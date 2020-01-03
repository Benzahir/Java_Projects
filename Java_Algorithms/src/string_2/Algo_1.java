package string_2;

public class Algo_1 {

	public static void main(String[] args) {
		
		System.out.println(doubleChar("Hi-There"));
	}
	
	public static String doubleChar(String str) {
		  
		  String rs="";
		  
		  for(int i=0; i<str.length(); i++){
		     rs+=str.substring(i,i+1)+str.substring(i,i+1);

		    }
		  
		  return rs;
		  
		}


}
