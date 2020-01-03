package string_2;

public class Algo_8 {

	public static void main(String[] args) {

		System.out.println(repeatEnd("Hello", 3));

	}
	
	public static String repeatEnd(String str, int n) {
		  
		  String rs="";
		  String rst="";
		  
		  for(int i=0; i<str.length(); i++){
		    
		    rs=str.substring(str.length()-n);
		     
		  }
		  
		  for(int j=0; j<n; j++){
		    rst+=rs;
		  }
		  
		  return rst;
		  
		  
		}


}
